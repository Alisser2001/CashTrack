package dao;

import dao.dto.ExpenseDTO;
import entities.money.Expense;
import exceptions.DAOException;
import exceptions.ExpenseException;
import interfaces.dao.IExpenseDAO;

import java.sql.*;

public class ExpenseDAO implements IExpenseDAO {
    private final Connection conn;
    public ExpenseDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public ExpenseDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM expenses WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Expense expense = new Expense();
                expense.setExpenseId(resultSet.getInt("id"));
                expense.setMoney(resultSet.getDouble("amount"));
                expense.setType(resultSet.getString("type"));
                expense.setDescription(resultSet.getString("description"));
                expense.setUserId(resultSet.getInt("userId"));
                expense.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                preparedStatement.close();
                return new ExpenseDTO(expense.getExpenseId(), expense.getMoney(), expense.getType(), expense.getDescription(), expense.getUserId(), expense.getDateTime());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public void createExpense(ExpenseDTO expenseDTO) throws DAOException {
        try{
            PreparedStatement getBalancePreparedStatement = conn.prepareStatement("SELECT *" +
                    "FROM accounts" +
                    "WHERE id = (" +
                    "    SELECT account" +
                    "    FROM users" +
                    "    WHERE id = ?" +
                    ");");
            getBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
            ResultSet accResultSet = getBalancePreparedStatement.executeQuery();
            double accBalance = accResultSet.getDouble("balance");
            getBalancePreparedStatement.close();
            if (accBalance < expenseDTO.getAmount()){
                throw new ExpenseException("No se poseen fondos suficientes. Saldo: " + accBalance);
            } else {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO expenses (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)");
                preparedStatement.setDouble(1, expenseDTO.getAmount());
                preparedStatement.setString(2, expenseDTO.getDescription());
                preparedStatement.setString(3, expenseDTO.getType());
                Timestamp timestamp = Timestamp.valueOf(expenseDTO.getDateTime());
                preparedStatement.setTimestamp(4, timestamp);
                preparedStatement.setInt(5, expenseDTO.getUserId());
                preparedStatement.executeUpdate();
                PreparedStatement updateBalancePreparedStatement = conn.prepareStatement("UPDATE accounts" +
                        "SET balance = balance - (" +
                        "    SELECT amount" +
                        "    FROM expenses" +
                        "    WHERE id = ?" +
                        ")" +
                        "WHERE id = (" +
                        "    SELECT accountId" +
                        "    FROM users" +
                        "    WHERE id = (" +
                        "        SELECT userId" +
                        "        FROM expenses" +
                        "        WHERE id = ?" +
                        "    )" +
                        ");");
                updateBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
                updateBalancePreparedStatement.setInt(2, expenseDTO.getExpenseId());
                updateBalancePreparedStatement.executeUpdate();
                updateBalancePreparedStatement.close();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        } catch (ExpenseException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteExpense(ExpenseDTO expenseDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM expenses WHERE id = ?");
            preparedStatement.setInt(1, expenseDTO.getExpenseId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement("UPDATE accounts" +
                    "SET balance = balance + (" +
                    "    SELECT amount" +
                    "    FROM expenses" +
                    "    WHERE id = ?" +
                    ")" +
                    "WHERE id = (" +
                    "    SELECT accountId" +
                    "    FROM users" +
                    "    WHERE id = (" +
                    "        SELECT userId" +
                    "        FROM expenses" +
                    "        WHERE id = ?" +
                    "    )" +
                    ");");
            updateBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
            updateBalancePreparedStatement.setInt(2, expenseDTO.getExpenseId());
            updateBalancePreparedStatement.executeUpdate();
            updateBalancePreparedStatement.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
}

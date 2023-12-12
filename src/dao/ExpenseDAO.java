package dao;

import dao.dto.ExpenseDTO;
import entities.money.ExpenseEntity;
import exceptions.DAOException;
import exceptions.ExpenseException;
import interfaces.dao.IExpenseDAO;

import java.sql.*;

public class ExpenseDAO implements IExpenseDAO {
    private final Connection conn;
    private static final String FIND_EXPENSE_BY_ID = "SELECT * FROM expenses WHERE id = ?";
    private static final String GET_ACCOUNT_BALANCE = "SELECT * FROM accounts WHERE id = (SELECT account FROM users WHERE id = ?);";
    private static final String CREATE_EXPENSE = "INSERT INTO expenses (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_BALANCE_REMOVE = "UPDATE accounts SET balance = balance - (SELECT amount FROM expenses WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM expenses WHERE id = ?));";
    private static final String DELETE_EXPENSE = "DELETE FROM expenses WHERE id = ?";
    private static final String UPDATE_BALANCE_ADD = "UPDATE accounts SET balance = balance + (SELECT amount FROM expenses WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM expenses WHERE id = ?));";

    public ExpenseDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public ExpenseDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_EXPENSE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ExpenseEntity expense = new ExpenseEntity();
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
            PreparedStatement getBalancePreparedStatement = conn.prepareStatement(GET_ACCOUNT_BALANCE);
            getBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
            ResultSet accResultSet = getBalancePreparedStatement.executeQuery();
            double accBalance = accResultSet.getDouble("balance");
            getBalancePreparedStatement.close();
            if (accBalance < expenseDTO.getAmount()){
                throw new ExpenseException("No se poseen fondos suficientes. Saldo: " + accBalance);
            } else {
                PreparedStatement preparedStatement = conn.prepareStatement(CREATE_EXPENSE);
                preparedStatement.setDouble(1, expenseDTO.getAmount());
                preparedStatement.setString(2, expenseDTO.getDescription());
                preparedStatement.setString(3, expenseDTO.getType());
                Timestamp timestamp = Timestamp.valueOf(expenseDTO.getDateTime());
                preparedStatement.setTimestamp(4, timestamp);
                preparedStatement.setInt(5, expenseDTO.getUserId());
                preparedStatement.executeUpdate();
                PreparedStatement updateBalancePreparedStatement = conn.prepareStatement(UPDATE_BALANCE_REMOVE);
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
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_EXPENSE);
            preparedStatement.setInt(1, expenseDTO.getExpenseId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement(UPDATE_BALANCE_ADD);
            updateBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
            updateBalancePreparedStatement.setInt(2, expenseDTO.getExpenseId());
            updateBalancePreparedStatement.executeUpdate();
            updateBalancePreparedStatement.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }

    @Override
    public void updateAmount(Float amount) {

    }

    @Override
    public void updateDescription(String description) {

    }

    @Override
    public void updateType(String type) {

    }
}

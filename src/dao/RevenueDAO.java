package dao;

import dao.dto.RevenueDTO;
import entities.money.Revenue;
import exceptions.DAOException;
import interfaces.dao.IRevenueDAO;

import java.sql.*;

public class RevenueDAO implements IRevenueDAO {
    private final Connection conn;
    public RevenueDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public RevenueDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM revenues WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Revenue revenue = new Revenue();
                revenue.setRevenueId(resultSet.getInt("id"));
                revenue.setMoney(resultSet.getDouble("amount"));
                revenue.setType(resultSet.getString("type"));
                revenue.setDescription(resultSet.getString("description"));
                revenue.setUserId(resultSet.getInt("userId"));
                revenue.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                preparedStatement.close();
                return new RevenueDTO(revenue.getRevenueId(), revenue.getMoney(), revenue.getType(), revenue.getDescription(), revenue.getUserId(), revenue.getDateTime());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public void createRevenue(RevenueDTO revenueDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO revenues (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setDouble(1, revenueDTO.getAmount());
            preparedStatement.setString(2, revenueDTO.getDescription());
            preparedStatement.setString(3, revenueDTO.getType());
            Timestamp timestamp = Timestamp.valueOf(revenueDTO.getDateTime());
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setInt(5, revenueDTO.getUserId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement("UPDATE accounts" +
                    "SET balance = balance + (" +
                    "    SELECT amount" +
                    "    FROM revenues" +
                    "    WHERE id = ?" +
                    ")" +
                    "WHERE id = (" +
                    "    SELECT accountId" +
                    "    FROM users" +
                    "    WHERE id = (" +
                    "        SELECT userId" +
                    "        FROM revenues" +
                    "        WHERE id = ?" +
                    "    )" +
                    ");");
            updateBalancePreparedStatement.setInt(1, revenueDTO.getRevenueId());
            updateBalancePreparedStatement.setInt(2, revenueDTO.getRevenueId());
            updateBalancePreparedStatement.executeUpdate();
            updateBalancePreparedStatement.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
    @Override
    public void deleteRevenue(RevenueDTO revenueDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM revenues WHERE id = ?");
            preparedStatement.setInt(1, revenueDTO.getRevenueId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement("UPDATE accounts" +
                    "SET balance = balance - (" +
                    "    SELECT amount" +
                    "    FROM revenues" +
                    "    WHERE id = ?" +
                    ")" +
                    "WHERE id = (" +
                    "    SELECT accountId" +
                    "    FROM users" +
                    "    WHERE id = (" +
                    "        SELECT userId" +
                    "        FROM revenues" +
                    "        WHERE id = ?" +
                    "    )" +
                    ");");
            updateBalancePreparedStatement.setInt(1, revenueDTO.getRevenueId());
            updateBalancePreparedStatement.setInt(2, revenueDTO.getRevenueId());
            updateBalancePreparedStatement.executeUpdate();
            updateBalancePreparedStatement.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
}

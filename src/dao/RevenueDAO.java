package dao;

import dao.dto.RevenueDTO;
import entities.money.RevenueEntity;
import exceptions.DAOException;
import interfaces.dao.IRevenueDAO;

import java.sql.*;

public class RevenueDAO implements IRevenueDAO {
    private final Connection conn;
    private static final String FIND_REVENUE_BY_ID = "SELECT * FROM revenues WHERE id = ?";
    private static final String CREATE_REVENUE = "INSERT INTO revenues (amount, description, type, date_time, userId) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_BALANCE_ADD = "UPDATE accounts SET balance = balance + (SELECT amount FROM revenues WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM revenues WHERE id = ?));";
    private static final String DELETE_REVENUE = "DELETE FROM revenues WHERE id = ?";
    private static final String UPDATE_BALANCE_REMOVE = "UPDATE accounts SET balance = balance - (SELECT amount FROM revenues WHERE id = ?) WHERE id = (SELECT accountId FROM users WHERE id = (SELECT userId FROM revenues WHERE id = ?));";

    public RevenueDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public RevenueDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_REVENUE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RevenueEntity revenue = new RevenueEntity();
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
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_REVENUE);
            preparedStatement.setDouble(1, revenueDTO.getAmount());
            preparedStatement.setString(2, revenueDTO.getDescription());
            preparedStatement.setString(3, revenueDTO.getType());
            Timestamp timestamp = Timestamp.valueOf(revenueDTO.getDateTime());
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setInt(5, revenueDTO.getUserId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement(UPDATE_BALANCE_ADD);
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
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_REVENUE);
            preparedStatement.setInt(1, revenueDTO.getRevenueId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement(UPDATE_BALANCE_REMOVE);
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
    public void updateAmount(Float amount) {

    }

    @Override
    public void updateDescription(String description) {

    }

    @Override
    public void updateType(String type) {

    }
}

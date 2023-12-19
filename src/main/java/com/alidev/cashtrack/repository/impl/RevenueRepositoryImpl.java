package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.dto.RevenueDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.RevenueRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RevenueRepositoryImpl implements RevenueRepository {
    private final JdbcTemplate jdbcTemplate;

    public RevenueRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RevenueDTO findById(int id) throws RepositoryException {
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
            throw new DAOException("Error al encontrar el ingreso.", (SQLException) e);
        }
        return null;
    }

    @Override
    public void createRevenue(RevenueDTO revenueDTO) throws RepositoryException {
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
    public void deleteRevenue(RevenueDTO revenueDTO) throws RepositoryException {
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
    public void updateDescription(int id, String description) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_DESCRIPTION);
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar el gasto.", (SQLException) e);
        }
    }

    @Override
    public void updateType(int id, String type) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_TYPE);
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar el gasto.", (SQLException) e);
        }
    }

    @Override
    public List<RevenueDTO> getRevenuesByUserId(int userId) throws RepositoryException {
        try {
            List<RevenueEntity> revenueEntities = new ArrayList<>();
            List<RevenueDTO> revenueDTOs = new ArrayList<>();
            PreparedStatement preparedStatement = conn.prepareStatement(GET_REVENUES_BY_USER_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                RevenueEntity revenueEntity = mapResultSetToRevenueEntity(resultSet);
                revenueEntities.add(revenueEntity);
            }
            revenueDTOs = mapRevenueEntitiesToDTOs(revenueEntities);
            return revenueDTOs;
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar los gastos", (SQLException) e);
        }
    }

    @Override
    public Map<String, Integer> getTypesRevenues() throws RepositoryException {
        return null;
    }
}

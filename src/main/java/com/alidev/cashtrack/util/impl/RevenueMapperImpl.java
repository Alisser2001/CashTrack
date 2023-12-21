package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.dto.impl.RevenueResponseDTOImpl;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.RevenueEntity;
import com.alidev.cashtrack.entity.impl.RevenueEntityImpl;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.util.RevenueMapper;
import org.springframework.dao.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RevenueMapperImpl implements RevenueMapper {
    @Override
    public RevenueEntity mapResultSetToRevenueEntity(ResultSet resultSet) throws DataAccessException, SQLException {
        int revenueId = resultSet.getInt("id");
        double amount = resultSet.getDouble("amount");
        String description = resultSet.getString("description");
        String type = resultSet.getString("type");
        LocalDateTime dateTime = resultSet.getTimestamp("date_time").toLocalDateTime();
        int userId = resultSet.getInt("userId");
        RevenueEntity expense = new RevenueEntityImpl();
        expense.setRevenueId(revenueId);
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setType(type);
        expense.setDateTime(dateTime);
        expense.setUserId(userId);
        return expense;
    }

    @Override
    public RevenueEntity mapRevenueDTOToRevenueEntity(MoneyRequestDTO revenueDTO) {
        RevenueEntity revenue = new RevenueEntityImpl();
        revenue.setAmount(revenueDTO.getAmount());
        revenue.setDescription(revenueDTO.getDescription());
        revenue.setType(revenueDTO.getType());
        revenue.setDateTime(revenueDTO.getDateTime());
        revenue.setUserId(revenueDTO.getUserId());
        return revenue;
    }

    @Override
    public RevenueResponseDTO mapRevenueEntityToRevenueDTO(RevenueEntity revenueEntity) {
        int revenueId = revenueEntity.getRevenueId();
        double amount = revenueEntity.getAmount();
        String description = revenueEntity.getDescription();
        String type = revenueEntity.getType();
        LocalDateTime dateTime = revenueEntity.getDateTime();
        int userId = revenueEntity.getUserId();
        return new RevenueResponseDTOImpl(
                revenueId,
                amount,
                type,
                description,
                userId,
                dateTime
        );
    }

    @Override
    public List<RevenueEntity> mapResultSetToRevenuesEntities(ResultSet resultSet) throws RepositoryException {
        try{
            List<RevenueEntity> revenuesEntities = new ArrayList<>();
            while (resultSet.next()) {
                RevenueEntity revenue = mapResultSetToRevenueEntity(resultSet);
                revenuesEntities.add(revenue);
            }
            return revenuesEntities;
        } catch(DataAccessException e){
            throw new RepositoryException("Error al mapear el resultado.", (DataAccessException) e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RevenueEntity> mapRevenuesDTOsToRevenuesEntities(List<MoneyRequestDTO> revenuesDTOs) {
        List<RevenueEntity> revEntities = new ArrayList<>();
        for (MoneyRequestDTO dto : revenuesDTOs) {
            RevenueEntity expense = mapRevenueDTOToRevenueEntity(dto);
            revEntities.add(expense);
        }
        return revEntities;
    }

    @Override
    public List<RevenueResponseDTO> mapRevenuesEntitiesToRevenuesDTOs(List<RevenueEntity> revenuesEntities) {
        List<RevenueResponseDTO> dtos = new ArrayList<>();
        for (RevenueEntity entity : revenuesEntities) {
            RevenueResponseDTO dto = mapRevenueEntityToRevenueDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}

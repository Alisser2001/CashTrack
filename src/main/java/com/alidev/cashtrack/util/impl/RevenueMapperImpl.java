package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.util.RevenueMapper;

public class RevenueMapperImpl implements RevenueMapper {
    private RevenueEntity mapResultSetToRevenueEntity(ResultSet resultSet) throws SQLException {
        int revenueId = resultSet.getInt("id");
        double amount = resultSet.getDouble("amount");
        String type = resultSet.getString("type");
        int userId = resultSet.getInt("userId");
        LocalDateTime dateTime = resultSet.getTimestamp("date_time").toLocalDateTime();
        String description = resultSet.getString("description");
        RevenueEntity revenue = new RevenueEntity(amount, type, description, userId, dateTime);
        revenue.setRevenueId(revenueId);
        return revenue;
    }

    private List<RevenueDTO> mapRevenueEntitiesToDTOs(List<RevenueEntity> entities) {
        List<RevenueDTO> dtos = new ArrayList<>();
        for (RevenueEntity entity : entities) {
            RevenueDTO dto = new RevenueDTO(entity.getRevenueId(), entity.getMoney(), entity.getType(), entity.getDescription(), entity.getUserId(), entity.getDateTime());
            dtos.add(dto);
        }
        return dtos;
    }
}

package com.alidev.cashtrack.util;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.entity.RevenueEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import org.springframework.dao.DataAccessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RevenueMapper {
    RevenueEntity mapResultSetToRevenueEntity(ResultSet resultSet) throws DataAccessException, SQLException;
    RevenueEntity mapRevenueDTOToRevenueEntity(MoneyRequestDTO revenueDTO);
    RevenueResponseDTO mapRevenueEntityToRevenueDTO(RevenueEntity revenueEntity);
    List<RevenueEntity> mapResultSetToRevenuesEntities(ResultSet resultSet) throws RepositoryException;
    List<RevenueEntity> mapRevenuesDTOsToRevenuesEntities(List<MoneyRequestDTO> revenuesDTOs);
    List<RevenueResponseDTO> mapRevenuesEntitiesToRevenuesDTOs(List<RevenueEntity> revenuesEntities);
}

package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.entity.RevenueEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.RevenueRepository;
import com.alidev.cashtrack.util.RevenueMapper;
import com.alidev.cashtrack.util.SQLSentences;
import com.alidev.cashtrack.util.impl.RevenueMapperImpl;
import com.alidev.cashtrack.util.impl.SQLSentencesImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public class RevenueRepositoryImpl implements RevenueRepository {
    private final JdbcTemplate jdbcTemplate;
    private SQLSentences sentences = new SQLSentencesImpl();
    private RevenueMapper revenueMapper = new RevenueMapperImpl();

    public RevenueRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RevenueEntity findById(int id) throws RepositoryException {
        try {
            String FIND_REVENUE_BY_ID = String.format(sentences.get_find_all_from_by_sentence(), "revenues", "id");
            return jdbcTemplate.queryForObject(FIND_REVENUE_BY_ID,
                    (resultSet, rowNum) -> revenueMapper.mapResultSetToRevenueEntity(resultSet),
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ingreso: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void createRevenue(RevenueEntity revenue) throws RepositoryException {
        try{
            String CREATE_REVENUE = String.format(sentences.get_create_money_sentence(), "revenues");
            Timestamp timestamp = Timestamp.valueOf(revenue.getDateTime());
            String UPDATE_BALANCE_ADD = String.format(sentences.get_update_balance_add_sentence(), "revenues", "revenues");
            jdbcTemplate.update(CREATE_REVENUE,
                    revenue.getAmount(),
                    revenue.getDescription(),
                    revenue.getType(),
                    timestamp,
                    revenue.getUserId());
            jdbcTemplate.update(UPDATE_BALANCE_ADD,
                    revenue.getRevenueId(),
                    revenue.getRevenueId());
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ingreso: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void deleteRevenue(int id) throws RepositoryException {
        try{
            String DELETE_REVENUE = String.format(sentences.get_delete_entity_sentence(), "revenues", "id");
            String UPDATE_BALANCE_REMOVE = String.format(sentences.get_update_balance_remove_sentence(), "revenues", "revenues");
            jdbcTemplate.update(DELETE_REVENUE,
                    id);
            jdbcTemplate.update(UPDATE_BALANCE_REMOVE,
                    id,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ingreso: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {
        try{
            String UPDATE_DESCRIPTION = String.format(sentences.get_update_value_sentence(), "revenues", "description", "id");
            jdbcTemplate.update(UPDATE_DESCRIPTION,
                    description,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ingreso: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateType(int id, String type) throws RepositoryException {
        try{
            String UPDATE_TYPE = String.format(sentences.get_update_value_sentence(), "revenues", "type", "id");
            jdbcTemplate.update(UPDATE_TYPE,
                    type,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ingreso: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public List<RevenueEntity> getRevenuesByUserId(int userId) throws RepositoryException {
        try {
            String GET_REVENUES_BY_USER_ID = String.format(sentences.get_all_from_by_sentence(), "revenues", "userId");
            return jdbcTemplate.queryForObject(GET_REVENUES_BY_USER_ID,
                    (resultSet, rowNum) -> {
                        try {
                            return revenueMapper.mapResultSetToRevenuesEntities(resultSet);
                        } catch (RepositoryException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    userId);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ingreso: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public Map<String, Integer> getTypesRevenues() throws RepositoryException {
        return null;
    }
}

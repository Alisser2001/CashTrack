package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.entity.RevenueEntity;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;
import java.util.Map;

public interface RevenueRepository {
    RevenueEntity findById(int id) throws RepositoryException;
    void createRevenue(RevenueEntity revenue) throws RepositoryException;
    void deleteRevenue(int id) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updateType(int id, String type) throws RepositoryException;
    List<RevenueEntity> getRevenuesByUserId(int userId) throws RepositoryException;
    Map<String, Integer> getTypesRevenues() throws RepositoryException;
}

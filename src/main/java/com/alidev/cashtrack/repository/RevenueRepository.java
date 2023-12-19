package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.dto.RevenueDTO;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;
import java.util.Map;

public interface RevenueRepository {
    RevenueDTO findById(int id) throws RepositoryException;
    void createRevenue(RevenueDTO revenueDTO) throws RepositoryException;
    void deleteRevenue(RevenueDTO revenueDTO) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updateType(int id, String type) throws RepositoryException;
    List<RevenueDTO> getRevenuesByUserId(int userId) throws RepositoryException;
    Map<String, Integer> getTypesRevenues() throws RepositoryException;
}

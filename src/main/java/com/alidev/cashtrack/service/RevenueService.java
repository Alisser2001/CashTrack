package com.alidev.cashtrack.service;

import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;
import java.util.Map;

public interface RevenueService {
    RevenueResponseDTO findById(int id) throws RepositoryException;
    void createRevenue(MoneyRequestDTO revenue) throws RepositoryException;
    void deleteRevenue(int id) throws RepositoryException;
    void updateDescription(int id, MoneyRequestDTO revenue) throws RepositoryException;
    void updateType(int id, MoneyRequestDTO revenue) throws RepositoryException;
    List<RevenueResponseDTO> getRevenuesByUserId(int userId) throws RepositoryException;
    Map<String, Integer> getTypesRevenues() throws RepositoryException;
}

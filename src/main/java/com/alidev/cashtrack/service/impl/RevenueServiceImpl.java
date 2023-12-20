package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.RevenueRepository;
import com.alidev.cashtrack.service.RevenueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository revenueRepository;

    public RevenueServiceImpl(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    @Override
    public RevenueResponseDTO findById(int id) throws RepositoryException {
        return null;
    }

    @Override
    public void createRevenue(MoneyRequestDTO revenueDTO) throws RepositoryException {

    }

    @Override
    public void deleteRevenue(MoneyRequestDTO revenueDTO) throws RepositoryException {

    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {

    }

    @Override
    public void updateType(int id, String type) throws RepositoryException {

    }

    @Override
    public List<RevenueResponseDTO> getRevenuesByUserId(int userId) throws RepositoryException {
        return null;
    }

    @Override
    public Map<String, Integer> getTypesRevenues() throws RepositoryException {
        return null;
    }
}

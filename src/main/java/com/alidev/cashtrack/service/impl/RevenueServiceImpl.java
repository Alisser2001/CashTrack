package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.entity.RevenueEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.RevenueRepository;
import com.alidev.cashtrack.service.RevenueService;
import com.alidev.cashtrack.util.RevenueMapper;
import com.alidev.cashtrack.util.impl.RevenueMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository revenueRepository;
    private RevenueMapper revenueMapper = new RevenueMapperImpl();

    public RevenueServiceImpl(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    @Override
    public RevenueResponseDTO findById(int id) throws RepositoryException {
        RevenueEntity revenueEntity = revenueRepository.findById(id);
        return revenueMapper.mapRevenueEntityToRevenueDTO(revenueEntity);
    }

    @Override
    public void createRevenue(MoneyRequestDTO revenueDTO) throws RepositoryException {
        RevenueEntity revenueEntity = revenueMapper.mapRevenueDTOToRevenueEntity(revenueDTO);
        revenueRepository.createRevenue(revenueEntity);
    }

    @Override
    public void deleteRevenue(int id) throws RepositoryException {
        revenueRepository.deleteRevenue(id);
    }

    @Override
    public void updateDescription(int id, MoneyRequestDTO revenue) throws RepositoryException {
        revenueRepository.updateDescription(id, revenue.getDescription());
    }

    @Override
    public void updateType(int id, MoneyRequestDTO revenue) throws RepositoryException {
        revenueRepository.updateType(id, revenue.getType());
    }

    @Override
    public List<RevenueResponseDTO> getRevenuesByUserId(int userId) throws RepositoryException {
        List<RevenueEntity> revenueEntities = revenueRepository.getRevenuesByUserId(userId);
        return revenueMapper.mapRevenuesEntitiesToRevenuesDTOs(revenueEntities);
    }

    @Override
    public Map<String, Integer> getTypesRevenues() throws RepositoryException {
        return null;
    }
}

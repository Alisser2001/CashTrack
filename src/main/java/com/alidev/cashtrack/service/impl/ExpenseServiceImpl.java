package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.ExpenseRepository;
import com.alidev.cashtrack.service.ExpenseService;
import com.alidev.cashtrack.util.ExpenseMapper;
import com.alidev.cashtrack.util.impl.ExpenseMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper = new ExpenseMapperImpl();

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponseDTO findById(int id) throws RepositoryException {
        ExpenseEntity expense = expenseRepository.findById(id);
        return expenseMapper.mapExpenseEntityToExpenseDTO(expense);
    }

    @Override
    public void createExpense(MoneyRequestDTO expenseDTO) throws RepositoryException {
        ExpenseEntity expenseEntity = expenseMapper.mapExpenseDTOToExpenseEntity(expenseDTO);
        expenseRepository.createExpense(expenseEntity);
    }

    @Override
    public void deleteExpense(int id) throws RepositoryException {
        expenseRepository.deleteExpense(id);
    }

    @Override
    public void updateDescription(int id, MoneyRequestDTO money) throws RepositoryException {
        expenseRepository.updateDescription(id, money.getDescription());
    }

    @Override
    public void updateType(int id, MoneyRequestDTO money) throws RepositoryException {
        expenseRepository.updateDescription(id, money.getType());
    }

    @Override
    public List<ExpenseResponseDTO> getExpensesByUserId(int userId) throws RepositoryException {
        List<ExpenseEntity> expensesEntities = expenseRepository.getExpensesByUserId(userId);
        return expenseMapper.mapExpensesEntitiesToExpensesDTOs(expensesEntities);
    }

    @Override
    public Map<String, Integer> getTypesExpenses() throws RepositoryException {
        return null;
    }
}

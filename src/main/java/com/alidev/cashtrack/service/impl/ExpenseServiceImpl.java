package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.ExpenseRepository;
import com.alidev.cashtrack.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponseDTO findById(int id) throws RepositoryException {
        return null;
    }

    @Override
    public void createExpense(MoneyRequestDTO expenseDTO) throws RepositoryException {

    }

    @Override
    public void deleteExpense(MoneyRequestDTO expenseDTO) throws RepositoryException {

    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {

    }

    @Override
    public void updateType(int id, String type) throws RepositoryException {

    }

    @Override
    public List<ExpenseResponseDTO> getExpensesByUserId(int userId) throws RepositoryException {
        return null;
    }

    @Override
    public Map<String, Integer> getTypesExpenses() throws RepositoryException {
        return null;
    }
}

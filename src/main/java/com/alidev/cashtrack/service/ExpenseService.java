package com.alidev.cashtrack.service;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    ExpenseResponseDTO findById(int id) throws RepositoryException;
    void createExpense(MoneyRequestDTO expense) throws RepositoryException;
    void deleteExpense(int id) throws RepositoryException;
    void updateDescription(int id, MoneyRequestDTO money) throws RepositoryException;
    void updateType(int id, MoneyRequestDTO money) throws RepositoryException;
    List<ExpenseResponseDTO> getExpensesByUserId(int userId) throws RepositoryException;
    Map<String, Integer> getTypesExpenses() throws RepositoryException;
}

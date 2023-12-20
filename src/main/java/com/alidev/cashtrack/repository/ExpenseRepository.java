package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;
import java.util.Map;

public interface ExpenseRepository {
    ExpenseEntity findById(int id) throws RepositoryException;
    void createExpense(ExpenseEntity expense) throws RepositoryException;
    void deleteExpense(ExpenseEntity expense) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updateType(int id, String type) throws RepositoryException;
    List<ExpenseEntity> getExpensesByUserId(int userId) throws RepositoryException;
    Map<String, Integer> getTypesExpenses() throws RepositoryException;
}

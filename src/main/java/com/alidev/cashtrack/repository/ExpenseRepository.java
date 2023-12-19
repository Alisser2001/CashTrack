package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.dto.ExpenseDTO;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;
import java.util.Map;

public interface ExpenseRepository {
    ExpenseDTO findById(int id) throws RepositoryException;
    void createExpense(ExpenseDTO expenseDTO) throws RepositoryException;
    void deleteExpense(ExpenseDTO expenseDTO) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updateType(int id, String type) throws RepositoryException;
    List<ExpenseDTO> getExpensesByUserId(int userId) throws RepositoryException;
    Map<String, Integer> getTypesExpenses() throws RepositoryException;
}

package com.alidev.cashtrack.controller;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.impl.MoneyRequestDTOImpl;
import com.alidev.cashtrack.exception.ExpenseException;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.service.AccountService;
import com.alidev.cashtrack.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final AccountService accountService;

    public ExpenseController(ExpenseService expenseService, AccountService accountService){
        this.expenseService = expenseService;
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<String> createExpense(@RequestParam int account, @RequestBody MoneyRequestDTOImpl newExpense) throws RepositoryException, ExpenseException {
        accountService.removeMoney(account, newExpense.getAmount());
        expenseService.createExpense(newExpense);
        return ResponseEntity.status(HttpStatus.CREATED).body("Gasto registrado con exito");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteExpense(@RequestParam int account, @RequestParam int id) throws RepositoryException, ExpenseException {
        ExpenseResponseDTO expense = expenseService.findById(id);
        accountService.addMoney(account, expense.getAmount());
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Gasto borrado con exito");
    }

    @GetMapping("/id")
    public ResponseEntity<ExpenseResponseDTO> getById(@RequestParam int id) throws RepositoryException {
        ExpenseResponseDTO expense = expenseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }

    @GetMapping("/user")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpensesByUserId(@RequestParam int user) throws RepositoryException {
        List<ExpenseResponseDTO> expenses = expenseService.getExpensesByUserId(user);
        return ResponseEntity.status(HttpStatus.OK).body(expenses);
    }

    @PutMapping("/description")
    public ResponseEntity<String> updateDescription(@RequestParam int id, @RequestBody MoneyRequestDTOImpl expense) throws RepositoryException {
        expenseService.updateDescription(id, expense);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Descripción del gasto actualizada con exito");
    }

    @PutMapping("/type")
    public ResponseEntity<String> updateType(@RequestParam int id, @RequestBody MoneyRequestDTOImpl expense) throws RepositoryException {
        expenseService.updateType(id, expense);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Tipo del gasto actualizado con exito");
    }
}

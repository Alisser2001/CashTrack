package com.alidev.cashtrack.controller;

import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.dto.impl.MoneyRequestDTOImpl;
import com.alidev.cashtrack.exception.ExpenseException;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.service.AccountService;
import com.alidev.cashtrack.service.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revenues")
public class RevenueController {
    private final RevenueService revenueService;
    private final AccountService accountService;

    public RevenueController(RevenueService revenueService, AccountService accountService){
        this.revenueService = revenueService;
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<String> createRevenue(@RequestParam int account, @RequestBody MoneyRequestDTOImpl newRevenue) throws RepositoryException, ExpenseException {
        accountService.addMoney(account, newRevenue.getAmount());
        revenueService.createRevenue(newRevenue);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ingreso registrado con exito");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteRevenue(@RequestParam int account, @RequestParam int id) throws RepositoryException, ExpenseException {
        RevenueResponseDTO revenue = revenueService.findById(id);
        accountService.removeMoney(account, revenue.getAmount());
        revenueService.deleteRevenue(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Ingreso borrado con exito");
    }

    @GetMapping("/id")
    public ResponseEntity<RevenueResponseDTO> getById(@RequestParam int id) throws RepositoryException {
        RevenueResponseDTO revenue = revenueService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(revenue);
    }

    @GetMapping("/user")
    public ResponseEntity<List<RevenueResponseDTO>> getRevenuesByUserId(@RequestParam int user) throws RepositoryException {
        List<RevenueResponseDTO> revenues = revenueService.getRevenuesByUserId(user);
        return ResponseEntity.status(HttpStatus.OK).body(revenues);
    }

    @PutMapping("/description")
    public ResponseEntity<String> updateDescription(@RequestParam int id, @RequestBody MoneyRequestDTOImpl revenue) throws RepositoryException {
        revenueService.updateDescription(id, revenue);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Descripción del ingreso actualizada con exito");
    }

    @PutMapping("/type")
    public ResponseEntity<String> updateType(@RequestParam int id, @RequestBody MoneyRequestDTOImpl revenue) throws RepositoryException {
        revenueService.updateType(id, revenue);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Tipo del ingreso actualizado con exito");
    }
}

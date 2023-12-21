package com.alidev.cashtrack.controller;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.RevenueResponseDTO;
import com.alidev.cashtrack.dto.impl.MoneyRequestDTOImpl;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.service.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revenues")
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService){
        this.revenueService = revenueService;
    }

    @PostMapping()
    public ResponseEntity<String> createRevenue(@RequestBody MoneyRequestDTOImpl newRevenue) throws RepositoryException {
        revenueService.createRevenue(newRevenue);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ingreso registrado con exito");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteRevenue(@RequestParam int id) throws RepositoryException {
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

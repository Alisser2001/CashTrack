package com.alidev.cashtrack.controller;

import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.dto.impl.AccountRequestDTOImpl;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<String> createAccount(@RequestBody AccountRequestDTOImpl newAccount) throws RepositoryException {
        accountService.createAccount(newAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cuenta creada con exito");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAccount(@RequestParam int id) throws RepositoryException {
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Cuenta borrada con exito");
    }

    @GetMapping("/id")
    public ResponseEntity<AccountResponseDTO> getAccountById(@RequestParam int id) throws RepositoryException {
        AccountResponseDTO account = accountService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @GetMapping("admin")
    public ResponseEntity<AccountResponseDTO> getAccountByAdminId(@RequestParam int admin) throws RepositoryException {
        AccountResponseDTO account = accountService.findByAdminId(admin);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PutMapping("/accountname")
    public ResponseEntity<String> updateAccountName(@RequestParam int id, @RequestBody AccountRequestDTOImpl account) throws RepositoryException {
        accountService.updateAccountName(id, account);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Nombre de cuenta actualizado con exito");
    }

    @PutMapping("/admin")
    public ResponseEntity<String> updateAdminId(@RequestParam int id, @RequestBody AccountRequestDTOImpl account) throws RepositoryException {
        accountService.updateAdminId(id, account);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Administrador de la cuenta actualizado con exito");
    }

    @PutMapping("/description")
    public ResponseEntity<String> updateDescription(@RequestParam int id, @RequestBody AccountRequestDTOImpl account) throws RepositoryException {
        accountService.updateDescription(id, account);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Descripción de la cuenta actualizada con exito");
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestParam int id, @RequestBody AccountRequestDTOImpl account) throws RepositoryException {
        accountService.updatePassword(id, account);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Contraseña de la cuenta actualizada con exito");
    }
}

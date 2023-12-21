package com.alidev.cashtrack.controller;

import com.alidev.cashtrack.dto.UserRequestDTO;
import com.alidev.cashtrack.dto.UserResponseDTO;
import com.alidev.cashtrack.dto.impl.UserRequestDTOImpl;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTOImpl newUser) throws RepositoryException {
        userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado con exito");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam int id) throws RepositoryException {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Usuario eliminado con exito");
    }

    @GetMapping("/id")
    public ResponseEntity<UserResponseDTO> getById(@RequestParam int id) throws RepositoryException {
        UserResponseDTO user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> getByEmail(@RequestParam String email) throws RepositoryException {
        UserResponseDTO user = userService.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/username")
    public ResponseEntity<UserResponseDTO> getByUsername(@RequestParam String username) throws RepositoryException {
        UserResponseDTO user = userService.findByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/username")
    public ResponseEntity<String> updateUsername(@RequestParam int id, @RequestBody UserRequestDTOImpl user) throws RepositoryException {
        userService.updateUsername(id, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Nombre de usuario actualizado con exito");
    }

    @PutMapping("/email")
    public ResponseEntity<String> updateEmail(@RequestParam int id, @RequestBody UserRequestDTOImpl user) throws RepositoryException {
        userService.updateEmail(id, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Correo de usuario actualizado con exito");
    }

    @PutMapping("/pin")
    public ResponseEntity<String> updatePin(@RequestParam int id, @RequestBody UserRequestDTOImpl user) throws RepositoryException {
        userService.updatePin(id, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pin de usuario actualizado con exito");
    }

    @PutMapping("/account")
    public ResponseEntity<String> updateUserAccount(@RequestParam int id, @RequestBody UserRequestDTOImpl user) throws RepositoryException {
        userService.updateAccountId(id, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cuenta del usuario actualizada con exito");
    }
}

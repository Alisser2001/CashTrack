package com.alidev.cashtrack.service;

import com.alidev.cashtrack.dto.UserRequestDTO;
import com.alidev.cashtrack.dto.UserResponseDTO;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;

public interface UserService {
    UserResponseDTO findById(int id) throws RepositoryException;
    UserResponseDTO findByEmail(String email) throws RepositoryException;
    UserResponseDTO findByUsername(String username) throws RepositoryException;
    void createUser(UserRequestDTO userDTO) throws RepositoryException;
    void deleteUser(UserRequestDTO userDTO) throws RepositoryException;
    void updateUsername(int id, String username) throws RepositoryException;
    void updateEmail(int id, String email) throws RepositoryException;    void updatePin(int id, String pin) throws RepositoryException;
    void updateAccountId(int userId, int accId) throws RepositoryException;
    List<UserResponseDTO> getUsersByAccountId(int id) throws RepositoryException;
}

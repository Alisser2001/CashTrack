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
    void deleteUser(int id) throws RepositoryException;
    void updateUsername(int id, UserRequestDTO user) throws RepositoryException;
    void updateEmail(int id, UserRequestDTO user) throws RepositoryException;
    void updatePin(int id, UserRequestDTO user) throws RepositoryException;
    void updateAccountId(int id, UserRequestDTO user) throws RepositoryException;
    List<UserResponseDTO> getUsersByAccountId(int id) throws RepositoryException;
}

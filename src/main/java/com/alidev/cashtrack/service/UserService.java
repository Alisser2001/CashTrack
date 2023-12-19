package com.alidev.cashtrack.service;

import com.alidev.cashtrack.dto.UserDTO;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;

public interface UserService {
    UserDTO findById(int id) throws RepositoryException;
    UserDTO findByEmail(String email) throws RepositoryException;
    UserDTO findByUsername(String username) throws RepositoryException;
    void createUser(UserDTO userDTO) throws RepositoryException;
    void deleteUser(UserDTO userDTO) throws RepositoryException;
    void updateUsername(int id, String username) throws RepositoryException;
    void updateEmail(int id, String email) throws RepositoryException;    void updatePin(int id, String pin) throws RepositoryException;
    void updateAccountId(int userId, int accId) throws RepositoryException;
    List<UserDTO> getUsersByAccountId(int id) throws RepositoryException;
}

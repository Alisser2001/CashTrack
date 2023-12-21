package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.entity.UserEntity;
import com.alidev.cashtrack.exception.RepositoryException;

import java.util.List;

public interface UserRepository {
    UserEntity findById(int id) throws RepositoryException;
    UserEntity findByEmail(String email) throws RepositoryException;
    UserEntity findByUsername(String username) throws RepositoryException;
    void createUser(UserEntity user) throws RepositoryException;
    void deleteUser(int id) throws RepositoryException;
    void updateUsername(int id, String username) throws RepositoryException;
    void updateEmail(int id, String email) throws RepositoryException;
    void updatePin(int id, String pin) throws RepositoryException;
    void updateAccountId(int userId, int accId) throws RepositoryException;
    List<UserEntity> getUsersByAccountId(int id) throws RepositoryException;
}

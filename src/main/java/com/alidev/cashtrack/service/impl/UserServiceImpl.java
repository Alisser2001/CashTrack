package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.UserDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO findById(int id) throws RepositoryException {
        return null;
    }

    @Override
    public UserDTO findByEmail(String email) throws RepositoryException {
        return null;
    }

    @Override
    public UserDTO findByUsername(String username) throws RepositoryException {
        return null;
    }

    @Override
    public void createUser(UserDTO userDTO) throws RepositoryException {

    }

    @Override
    public void deleteUser(UserDTO userDTO) throws RepositoryException {

    }

    @Override
    public void updateUsername(int id, String username) throws RepositoryException {

    }

    @Override
    public void updateEmail(int id, String email) throws RepositoryException {

    }

    @Override
    public void updatePin(int id, String pin) throws RepositoryException {

    }

    @Override
    public void updateAccountId(int userId, int accId) throws RepositoryException {

    }

    @Override
    public List<UserDTO> getUsersByAccountId(int id) throws RepositoryException {
        return null;
    }
}

package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.UserRequestDTO;
import com.alidev.cashtrack.dto.UserResponseDTO;
import com.alidev.cashtrack.entity.UserEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.UserRepository;
import com.alidev.cashtrack.service.UserService;
import com.alidev.cashtrack.util.UserMapper;
import com.alidev.cashtrack.util.impl.UserMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper = new UserMapperImpl();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO findById(int id) throws RepositoryException {
        UserEntity userEntity = userRepository.findById(id);
        return userMapper.mapUserEntityToUserDTO(userEntity);
    }

    @Override
    public UserResponseDTO findByEmail(String email) throws RepositoryException {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userMapper.mapUserEntityToUserDTO(userEntity);
    }

    @Override
    public UserResponseDTO findByUsername(String username) throws RepositoryException {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userMapper.mapUserEntityToUserDTO(userEntity);
    }

    @Override
    public void createUser(UserRequestDTO userDTO) throws RepositoryException {
        UserEntity userEntity = userMapper.mapUserDTOToUserEntity(userDTO);
        userRepository.createUser(userEntity);
    }

    @Override
    public void deleteUser(int id) throws RepositoryException {
        userRepository.deleteUser(id);
    }

    @Override
    public void updateUsername(int id, UserRequestDTO user) throws RepositoryException {
        userRepository.updateUsername(id, user.getUsername());
    }

    @Override
    public void updateEmail(int id, UserRequestDTO user) throws RepositoryException {
        userRepository.updateEmail(id, user.getEmail());
    }

    @Override
    public void updatePin(int id, UserRequestDTO user) throws RepositoryException {
        userRepository.updatePin(id, user.getPin());
    }

    @Override
    public void updateAccountId(int id, UserRequestDTO user) throws RepositoryException {
        userRepository.updateAccountId(id, user.getAccountId());
    }

    @Override
    public List<UserResponseDTO> getUsersByAccountId(int id) throws RepositoryException {
        return null;
    }
}

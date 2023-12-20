package com.alidev.cashtrack.util.impl;
import com.alidev.cashtrack.dto.UserRequestDTO;
import com.alidev.cashtrack.dto.UserResponseDTO;
import com.alidev.cashtrack.dto.impl.UserResponseDTOImpl;
import com.alidev.cashtrack.entity.UserEntity;
import com.alidev.cashtrack.entity.impl.UserEntityImpl;
import com.alidev.cashtrack.util.UserMapper;
import org.springframework.dao.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity mapResultSetToUserEntity(ResultSet resultSet) throws DataAccessException, SQLException {
        int userId = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        int accId = resultSet.getInt("account");
        UserEntity user = new UserEntityImpl();
        user.setUserId(userId);
        user.setUsername(username);
        user.setEmail(email);
        user.setAccountId(accId);
        return user;
    }

    @Override
    public UserEntity mapUserDTOToUserEntity(UserRequestDTO userDTO) {
        UserEntity user = new UserEntityImpl();
        user.setUsername((userDTO.getUsername()));
        user.setEmail(userDTO.getEmail());
        user.setAccountId(userDTO.getAccountId());
        return user;
    }

    @Override
    public UserResponseDTO mapUserEntityToUserDTO(UserEntity userEntity) {
        int userId = userEntity.getUserId();
        String username = userEntity.getUsername();
        String email = userEntity.getEmail();
        int accId = userEntity.getAccountId();
        return new UserResponseDTOImpl(
                userId,
                username,
                email,
                accId
        );
    }

    @Override
    public List<UserEntity> mapResultSetToUsersEntities(ResultSet resultSet) {
        return null;
    }

    @Override
    public List<UserEntity> mapUsersDTOsToUsersEntities(List<UserRequestDTO> usersDTOs) {
        List<UserEntity> usersEntities = new ArrayList<>();
        for (UserRequestDTO dto : usersDTOs) {
            UserEntity user = mapUserDTOToUserEntity(dto);
            usersEntities.add(user);
        }
        return usersEntities;
    }

    @Override
    public List<UserResponseDTO> mapUsersEntitiesToUsersDTOs(List<UserEntity> usersEntities) {
        List<UserResponseDTO> usersDTOs = new ArrayList<>();
        for (UserEntity entity : usersEntities) {
            UserResponseDTO user = mapUserEntityToUserDTO(entity);
            usersDTOs.add(user);
        }
        return usersDTOs;
    }
}

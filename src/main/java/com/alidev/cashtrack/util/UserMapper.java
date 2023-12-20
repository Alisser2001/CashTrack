package com.alidev.cashtrack.util;
import com.alidev.cashtrack.dto.UserRequestDTO;
import com.alidev.cashtrack.dto.UserResponseDTO;
import com.alidev.cashtrack.entity.UserEntity;
import org.springframework.dao.DataAccessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserMapper {
    UserEntity mapResultSetToUserEntity(ResultSet resultSet) throws DataAccessException, SQLException;
    UserEntity mapUserDTOToUserEntity(UserRequestDTO userDTO);
    UserResponseDTO mapUserEntityToUserDTO(UserEntity userEntity);
    List<UserEntity> mapResultSetToUsersEntities(ResultSet resultSet);
    List<UserEntity> mapUsersDTOsToUsersEntities(List<UserRequestDTO> usersDTOs);
    List<UserResponseDTO> mapUsersEntitiesToUsersDTOs(List<UserEntity> usersEntities);
}

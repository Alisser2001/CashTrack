package interfaces.dao;

import dao.dto.UserDTO;
import exceptions.DAOException;

public interface IUserDAO {
    UserDTO findById(int id) throws DAOException;
    UserDTO findByEmail(String email) throws DAOException;
    UserDTO findByUsername(String username) throws DAOException;
    void createUser(UserDTO userDTO) throws DAOException;
    void deleteUser(UserDTO userDTO) throws DAOException;
}

package interfaces.dao;

import dao.dto.UserDTO;

public interface IUserDAO {
    UserDTO findById(int id);
    UserDTO findByEmail(String email);
    UserDTO findByUsername(String username);
    void createUser(UserDTO userDTO);
    void deleteUser(int id);
}

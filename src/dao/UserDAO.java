package dao;

import dao.dto.UserDTO;
import interfaces.dao.IUserDAO;

public class UserDAO implements IUserDAO {
    @Override
    public UserDTO findById(int id) {
        return null;
    }
    @Override
    public UserDTO findByEmail(String email) {
        return null;
    }
    @Override
    public UserDTO findByUsername(String username) {
        return null;
    }
    @Override
    public void createUser(UserDTO userDTO) {

    }
    @Override
    public void deleteUser(int id) {

    }
}

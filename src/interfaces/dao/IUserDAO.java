package interfaces.dao;

public interface IUserDAO {
    UserDTO findById(int id);
    void createUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(int id);
}

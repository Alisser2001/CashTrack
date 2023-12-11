package interfaces.dao.dto;

import entities.user.User;
import java.util.List;

public interface IAccountDTO {
    // Métodos obligatorios en la transferencia de la capa de presentación a la DB y vicenversa
    int getAdminId();
    String getAccountName();
    String getDescription();
    Double getBalance();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
    String getPassword();
    List<User> getUsers();
}

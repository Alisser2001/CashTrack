package interfaces.dao.dto;

public interface IUserDTO {
    String getUsername();
    String getEmail();
    int getAccountId();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
    String getPin();
}

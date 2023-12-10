package interfaces.dao.dto;

import dao.dto.UserDTO;
import entities.money.Expense;
import entities.money.Revenue;
import entities.money.TypeExpenses;
import entities.money.TypeRevenues;
import entities.user.User;

import java.util.List;
import java.util.Map;

public interface IAccountDTO {
    // Métodos obligatorios en la transferencia de la capa de presentación a la DB y vicenversa
    UserDTO getAdmin();
    String getAccountName();
    String getDescription();
    Double getBalance();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
    String getPassword();
    List<User> getUsers();
    List<Expense> getExpenses();
    List<Revenue> getRevenues();
    Map<TypeExpenses, Integer> getTypesExpenses();
    Map<TypeRevenues, Integer> getTypesRevenues();
}

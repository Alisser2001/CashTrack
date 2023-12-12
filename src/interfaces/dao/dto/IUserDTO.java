package interfaces.dao.dto;

import entities.money.ExpenseEntity;
import entities.money.RevenueEntity;

import java.util.List;
import java.util.Map;

public interface IUserDTO {
    String getUsername();
    String getEmail();
    int getAccountId();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
    String getPin();
    List<ExpenseEntity> getExpenses();
    List<RevenueEntity> getRevenues();
    Map<String, Integer> getTypesExpenses();
    Map<String, Integer> getTypesRevenues();
}

package interfaces.dao.dto;

import entities.money.Expense;
import entities.money.Revenue;
import entities.money.TypeExpenses;
import entities.money.TypeRevenues;
import entities.user.User;

import java.util.List;
import java.util.Map;

public interface IAccountDTO {
    int getAccountId();
    User getAdmin();
    String getName();
    String getEmail();
    Double getBalance();
    List<User> getUsers();
    List<Expense> getExpenses();
    List<Revenue> getRevenues();
    Map<TypeExpenses, Integer> getTypesExpenses();
    Map<TypeRevenues, Integer> getTypesRevenues();
}

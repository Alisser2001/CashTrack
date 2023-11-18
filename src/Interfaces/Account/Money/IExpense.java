package Interfaces.Account.Money;
import Account.Money.TypeExpenses;

public interface IExpense extends IMoney<TypeExpenses>{
    int getExpenseId();
}

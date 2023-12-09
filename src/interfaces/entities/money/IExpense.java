package interfaces.entities.money;
import entities.money.TypeExpenses;

public interface IExpense extends IMoney<TypeExpenses>{
    int getExpenseId();
}

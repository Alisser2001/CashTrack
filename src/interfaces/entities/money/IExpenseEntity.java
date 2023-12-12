package interfaces.entities.money;

public interface IExpenseEntity extends IMoneyEntity {
    int getExpenseId();
    void setExpenseId(int id);
}

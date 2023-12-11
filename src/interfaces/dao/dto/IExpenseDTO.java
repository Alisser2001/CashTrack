package interfaces.dao.dto;

public interface IExpenseDTO extends IMoneyDTO{
    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getExpenseId();
}

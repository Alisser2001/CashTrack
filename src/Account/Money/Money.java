package Account.Money;
import Interfaces.Account.Money.IMoney;
import java.time.LocalDateTime;

abstract class Money<T extends Types> implements IMoney<T> {
    private Double money;
    private String description;
    private LocalDateTime date_time;
    private T type;
    private static int expenses_amount = 0;
    private static int revenues_amount = 0;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money){
        this.money = money;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getDateTime(){
        return date_time;
    }
    public T getType() {
        return type;
    }
    public void setType(T type){
        this.type = type;
    }
    public void setDateTime(LocalDateTime date_time){
        this.date_time = date_time;
    }

    public static int getExpensesAmount(){
        return expenses_amount;
    }
    public static int getRevenuesAmount(){
        return revenues_amount;
    }
    public static void updateExpensesAmount(){
        expenses_amount += 1;
    }
    public static void updateRevenuesAmount(){
        revenues_amount += 1;
    }
}

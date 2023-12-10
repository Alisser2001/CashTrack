package entities.money;
import entities.user.User;
import interfaces.entities.money.IMoney;
import java.time.LocalDateTime;

abstract class Money<T extends Types> implements IMoney<T> {
    private Double money;
    private String description;
    private LocalDateTime date_time;
    private T type;
    private User user;

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
    public void setDateTime(LocalDateTime date_time){
        this.date_time = date_time;
    }
    public User getUserId(){
        return user;
    }
    public void setUserId(int id){
        this.user = id;
    }
    public T getType() {
        return type;
    }
    public void setType(T type){
        this.type = type;
    }
}

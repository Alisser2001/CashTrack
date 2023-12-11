package entities.money;

import interfaces.entities.money.IMoney;
import java.time.LocalDateTime;

abstract class Money implements IMoney {
    private Double money;
    private String description;
    private LocalDateTime date_time;
    private String type;
    private int userId;

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
    public int getUserId(){
        return userId;
    }
    public void setUserId(int id){
        this.userId = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}

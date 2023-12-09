package entities.money;

import entities.user.User;
import interfaces.entities.money.IRevenue;

import java.time.LocalDateTime;

public class Revenue extends Money<TypeRevenues> implements IRevenue {
    private int revenue_id;
    public Revenue(Double revenue, TypeRevenues type, String description, User user){
        this.setMoney(revenue);
        this.setDescription(description);
        this.setDateTime(LocalDateTime.now());
        this.setUser(user);
        this.setType(type);
    }
    public int getRevenueId(){
        return revenue_id;
    }
    public void setRevenueId(int id){
        this.revenue_id = id;
    }
    @Override
    public String toString(){
        return this.getRevenueId() + ". " + this.getMoney() + " (" + this.getType() + "): " + this.getDescription();
    }
}

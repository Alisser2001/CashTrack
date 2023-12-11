package entities.money;

import interfaces.entities.money.IRevenue;
import java.time.LocalDateTime;

public class Revenue extends Money implements IRevenue {
    private int revenue_id;
    public Revenue() { }
    public Revenue(Double revenue, String type, String description, int userId){
        this.setMoney(revenue);
        this.setDescription(description);
        this.setDateTime(LocalDateTime.now());
        this.setUserId(userId);
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

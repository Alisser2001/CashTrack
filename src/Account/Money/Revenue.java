package Account.Money;

import Interfaces.Account.Money.IRevenue;

import java.time.LocalDateTime;

public class Revenue extends Money<TypeRevenues> implements IRevenue {
    private final int revenue_id;
    public Revenue(Double revenue, TypeRevenues type, String description){
        this.setMoney(revenue);
        this.setDescription(description);
        this.setDateTime(LocalDateTime.now());
        this.setType(type);
        this.revenue_id = Money.getRevenuesAmount();
        Money.updateRevenuesAmount();
    }
    public int getRevenueId(){
        return revenue_id;
    }
    @Override
    public String toString(){
        return this.getRevenueId() + ". " + this.getMoney() + " (" + this.getType() + "): " + this.getDescription();
    }
}

package Account.Money;

import Interfaces.Account.Money.IRevenue;

public class Revenue extends Money implements IRevenue {
    private int revenue_id;
    private TypeRevenues type;
    public Revenue(Double revenue, TypeRevenues type, String description){
        this.setMoney(revenue);
        this.setDescription(description);
        this.type = type;
        this.revenue_id = Money.getRevenuesAmount();
        Money.updateRevenuesAmount();
    }
    public int getRevenueId(){
        return revenue_id;
    }
    public TypeRevenues getType() {
        return type;
    }
    @Override
    public String toString(){
        return this.getRevenueId() + ". " + this.getMoney() + " (" + this.getType() + "): " + this.getDescription();
    }
}

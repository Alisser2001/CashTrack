package Account.Money;

public class Revenue extends Money{
    private int revenue_id;
    public Revenue(Double revenue, String description){
        this.setMoney(revenue);
        this.setDescription(description);
        this.revenue_id = Money.getRevenuesAmount();
        Money.updateRevenuesAmount();
    }
    public int getRevenueId(){
        return revenue_id;
    }
    @Override
    public String toString(){
        return this.getMoney() + ": " + this.getDescription();
    }
}

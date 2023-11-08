package Account.Money;

public class Revenue extends Money{
    public Revenue(Double revenue, String description){
        this.setMoney(revenue);
        this.setDescription(description);
    }
    @Override
    public String toString(){
        return this.getMoney() + ": " + this.getDescription();
    }
}

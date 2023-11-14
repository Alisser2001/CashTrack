package Account.Money;

abstract class Money {
    private Double money;
    private String description;
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

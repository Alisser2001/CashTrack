package Account.Money;

public class TypeExpenses extends Types{
    public TypeExpenses(String type, String description) {
        this.setType(type);
        this.setDescription(description);
    }
    @Override
    public String toString() {
        return "ExpenseType: " + this.getType() + "\n" +
                "Description: " + this.getDescription();
    }
}

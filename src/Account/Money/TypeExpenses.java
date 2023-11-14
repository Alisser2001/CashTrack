package Account.Money;

public class TypeExpenses {
    private final String type;
    private String description;
    public TypeExpenses(String type, String description) {
        this.type = type;
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String toString() {
        return "ExpenseType: " + type + "\n" +
                "Description: " + description;
    }
}

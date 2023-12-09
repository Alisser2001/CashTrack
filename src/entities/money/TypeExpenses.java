package entities.money;

import java.util.Objects;

public class TypeExpenses extends Types{
    public TypeExpenses(String type) {
        this.setType(type);
    }
    @Override
    public String toString() {
        return "ExpenseType: " + this.getType();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeExpenses that = (TypeExpenses) o;
        return this.getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}

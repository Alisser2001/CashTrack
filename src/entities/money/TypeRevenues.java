package entities.money;

import java.util.Objects;

public class TypeRevenues extends Types{
    public TypeRevenues(String type) {
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
        TypeRevenues that = (TypeRevenues) o;
        return this.getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}

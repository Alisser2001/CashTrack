package entities.money;

import interfaces.entities.money.ITypes;

public class Types implements ITypes {
    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type){ this.type = type; }
}

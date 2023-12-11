package interfaces.entities.money;

import entities.money.Types;
import java.time.LocalDateTime;

public interface IMoney {
    Double getMoney();
    void setMoney(Double money);
    String getDescription();
    void setDescription(String description);
    Types getType();
    void setType(Types type);
    LocalDateTime getDateTime();
    void setDateTime(LocalDateTime date_time);
    int getUserId();
    void setUserId(int id);
}
package interfaces.entities.money;

import java.time.LocalDateTime;

public interface IMoney {
    Double getMoney();
    void setMoney(Double money);
    String getDescription();
    void setDescription(String description);
    String getType();
    void setType(String type);
    LocalDateTime getDateTime();
    void setDateTime(LocalDateTime date_time);
    int getUserId();
    void setUserId(int id);
}
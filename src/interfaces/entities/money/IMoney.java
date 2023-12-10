package interfaces.entities.money;

import entities.user.User;

import java.time.LocalDateTime;

public interface IMoney<T extends ITypes> {
    Double getMoney();
    void setMoney(Double money);
    String getDescription();
    void setDescription(String description);
    LocalDateTime getDateTime();
    void setDateTime(LocalDateTime date_time);
    User getUserId();
    void setUserId(int id);
    T getType();
    void setType(T type);
}
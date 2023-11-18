package Interfaces.Account.Money;

import java.time.LocalDateTime;

public interface IMoney {
    Double getMoney();
    void setMoney(Double money);
    String getDescription();
    void setDescription(String description);
    LocalDateTime getDateTime();
    void setDateTime(LocalDateTime date_time);
}
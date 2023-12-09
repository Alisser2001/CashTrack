package interfaces.dao;

public interface IRevenueDAO {
    RevenueDTO findById(int id);
    void createRevenue(RevenueDTO revenueDTO);
    void updateRevenue(RevenueDTO revenueDTO);
    void deleteRevenue(int id);
}

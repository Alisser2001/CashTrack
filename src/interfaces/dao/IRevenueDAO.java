package interfaces.dao;

import dao.dto.RevenueDTO;

public interface IRevenueDAO {
    RevenueDTO findById(int id);
    void createRevenue(RevenueDTO revenueDTO);
    void deleteRevenue(int id);
}

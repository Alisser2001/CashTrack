package interfaces.dao;

import dao.dto.RevenueDTO;
import exceptions.DAOException;

public interface IRevenueDAO {
    RevenueDTO findById(int id) throws DAOException;
    void createRevenue(RevenueDTO revenueDTO) throws DAOException;
    void deleteRevenue(RevenueDTO revenueDTO) throws DAOException;
    void updateAmount(Float amount);
    void updateDescription(String description);
    void updateType(String type);
}

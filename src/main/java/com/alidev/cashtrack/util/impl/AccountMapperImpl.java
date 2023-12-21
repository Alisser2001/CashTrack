package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.dto.impl.AccountResponseDTOImpl;
import com.alidev.cashtrack.entity.AccountEntity;
import com.alidev.cashtrack.entity.impl.AccountEntityImpl;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.util.AccountMapper;
import org.springframework.dao.DataAccessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountMapperImpl implements AccountMapper {
    @Override
    public AccountEntity mapResultSetToAccountEntity(ResultSet resultSet) throws DataAccessException, SQLException {
        int accId = resultSet.getInt("id");
        String accName = resultSet.getString("accountName");
        int adminId = resultSet.getInt("adminId");
        String descr = resultSet.getString("description");
        String pass = resultSet.getString("password");
        double balance = resultSet.getDouble("balance");
        AccountEntity account = new AccountEntityImpl();
        account.setAccountId(accId);
        account.setAccountName(accName);
        account.setAdminId(adminId);
        account.setDescription(descr);
        account.setPassword(pass);
        account.setBalance(balance);
        return account;
    }

    @Override
    public AccountEntity mapAccountDTOToAccountEntity(AccountRequestDTO accountDTO) {
        AccountEntity account = new AccountEntityImpl();
        account.setAccountName(accountDTO.getAccountName());
        account.setAdminId(accountDTO.getAdminId());
        account.setDescription(accountDTO.getDescription());
        account.setPassword(accountDTO.getPassword());
        account.setBalance(accountDTO.getBalance() != null ? accountDTO.getBalance() : 0.0);
        return account;
    }

    @Override
    public AccountResponseDTO mapAccountEntityToAccountDTO(AccountEntity accountEntity) {
         int accountId = accountEntity.getAccountId();
         String accountName = accountEntity.getAccountName();
         int adminId = accountEntity.getAdminId();
         String description = accountEntity.getDescription();
         double balance = accountEntity.getBalance();
         return new AccountResponseDTOImpl(
                 accountId,
                 adminId,
                 accountName,
                 description,
                 balance
         );
    }

    @Override
    public List<AccountEntity> mapResulSetToAccountsEntities(ResultSet resultSet) throws RepositoryException {
        try{
            List<AccountEntity> accountEntities = new ArrayList<>();
            while (resultSet.next()) {
                AccountEntity account = mapResultSetToAccountEntity(resultSet);
                accountEntities.add(account);
            }
            return accountEntities;
        } catch(DataAccessException e){
            throw new RepositoryException("Error al mapear el resultado.", (DataAccessException) e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AccountEntity> mapAccountsDTOsToAccountsEntities(List<AccountRequestDTO> accountsDTOs) {
        List<AccountEntity> accEntities = new ArrayList<>();
        for (AccountRequestDTO dto : accountsDTOs) {
            AccountEntity account = mapAccountDTOToAccountEntity(dto);
            accEntities.add(account);
        }
        return accEntities;
    }

    @Override
    public List<AccountResponseDTO> mapAccountsEntitiesToAccountsDTOs(List<AccountEntity> accountsEntities) {
        List<AccountResponseDTO> accDTOs = new ArrayList<>();
        for (AccountEntity entity : accountsEntities) {
            AccountResponseDTO account = mapAccountEntityToAccountDTO(entity);
            accDTOs.add(account);
        }
        return accDTOs;
    }
}

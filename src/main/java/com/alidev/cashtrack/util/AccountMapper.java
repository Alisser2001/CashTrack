package com.alidev.cashtrack.util;
import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.entity.AccountEntity;
import org.springframework.dao.DataAccessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AccountMapper {
    AccountEntity mapResultSetToAccountEntity(ResultSet resultSet) throws DataAccessException, SQLException;
    AccountEntity mapAccountDTOToAccountEntity(AccountRequestDTO accountDTO);
    AccountResponseDTO mapAccountEntityToAccountDTO(AccountEntity accountEntity);
    List<AccountEntity> mapResulSetToAccountsEntities(ResultSet resultSet);
    List<AccountEntity> mapAccountsDTOsToAccountsEntities(List<AccountRequestDTO> accountsDTOs);
    List<AccountResponseDTO> mapAccountsEntitiesToAccountsDTOs(List<AccountEntity> accountsEntities);
}

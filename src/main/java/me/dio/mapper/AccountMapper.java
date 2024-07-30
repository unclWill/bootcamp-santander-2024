package me.dio.mapper;

import me.dio.domain.model.Account;
import me.dio.dto.AccountDTO;

/**
 * @author William
 * @date 29/07/2024
 */

public class AccountMapper {
    public static AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }

        AccountDTO dto = new AccountDTO();
        dto.setNumber(account.getNumber());
        dto.setAgency(account.getAgency());
        dto.setBalance(account.getBalance());
        dto.setLimit(account.getLimit());
        return dto;
    }

    public static Account toEntity(AccountDTO dto) {
        if (dto == null) {
            return null;
        }

        Account account = new Account();
        account.setNumber(dto.getNumber());
        account.setAgency(dto.getAgency());
        account.setBalance(dto.getBalance());
        account.setLimit(dto.getLimit());
        return account;
    }
}
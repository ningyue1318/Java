package com.syn.springDemo.Service;

import com.syn.springDemo.Dao.Account;

import java.util.List;

public interface IAccountService {
    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountById(Integer accountId);

    List<Account> findAllAccount();
}

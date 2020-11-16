package com.syn.bibiCourse.Spring.springDemo.Service;

import com.syn.bibiCourse.Spring.springDemo.Dao.Account;

import java.util.List;

public interface IAccountService {
    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountById(Integer accountId);

    List<Account> findAllAccount();
}

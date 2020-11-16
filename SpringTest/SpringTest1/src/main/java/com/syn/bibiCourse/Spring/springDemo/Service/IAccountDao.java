package com.syn.bibiCourse.Spring.springDemo.Service;

import com.syn.bibiCourse.Spring.springDemo.Dao.Account;

import java.util.List;

public interface IAccountDao {
    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}

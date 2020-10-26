package com.syn.bibiCourse.springDemo.Impl;

import com.syn.bibiCourse.springDemo.Dao.Account;
import com.syn.bibiCourse.springDemo.Service.IAccountDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoImpl implements IAccountDao {
    private Map<Integer,Account> db;


    public AccountDaoImpl(HashMap db){
        this.db = new HashMap<>();
    }

    @Override
    public void save(Account account) {
        db.put(account.getId(),account);
    }

    @Override
    public void update(Account account) {
        db.put(account.getId(),account);
    }

    @Override
    public void delete(Integer accountId) {
        db.remove(accountId);
    }

    @Override
    public Account findById(Integer accountId) {
        return db.get(accountId);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) db.values();
    }
}

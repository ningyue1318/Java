package com.itheima.Dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

public interface AccountDao {
    List<AccountUser> findAll();
    List<AccountUser> findAllAccount();
}

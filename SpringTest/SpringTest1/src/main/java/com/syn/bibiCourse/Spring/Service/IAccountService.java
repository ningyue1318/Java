package com.syn.bibiCourse.Spring.Service;

import com.syn.bibiCourse.Spring.springDemo.Dao.Account;

public interface IAccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceName,String targetName, Float money);
}

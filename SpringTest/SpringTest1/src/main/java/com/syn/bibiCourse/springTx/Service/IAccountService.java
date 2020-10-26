package com.syn.bibiCourse.springTx.Service;

import com.syn.bibiCourse.springDemo.Dao.Account;

public interface IAccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceName,String targetName, Float money);
}

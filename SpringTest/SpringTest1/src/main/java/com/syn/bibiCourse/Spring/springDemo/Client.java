package com.syn.bibiCourse.Spring.springDemo;

import com.syn.bibiCourse.Spring.springDemo.Dao.Account;
import com.syn.bibiCourse.Spring.springDemo.Service.IAccountDao;
import com.syn.bibiCourse.Spring.springDemo.Service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/bean.xml");

        IAccountService accountService = (IAccountService)ac.getBean("accountService");
        IAccountDao accountDao = (IAccountDao)ac.getBean("accountDao");

        Account account = new Account();
        account.setName("黑马程序员");
        account.setId(1);
        account.setMoney(100000f);
        accountService.saveAccount(account);

        System.out.println(accountService.findAccountById(1));



    }
}

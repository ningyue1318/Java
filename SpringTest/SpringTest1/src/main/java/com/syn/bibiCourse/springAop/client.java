package com.syn.bibiCourse.springAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter3.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}

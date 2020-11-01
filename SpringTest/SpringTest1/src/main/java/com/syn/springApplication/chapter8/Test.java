package com.syn.springApplication.chapter8;


import com.syn.springApplication.chapter7.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter7.xml");
        Waiter waiter = (Waiter) ac.getBean("waiter");
        waiter.greetTo("join");
    }
}

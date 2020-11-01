package com.syn.springApplication.chapter7;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeAdviceTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter7.xml");
        NaiveWaiter waiter = (NaiveWaiter) ac.getBean("waiter");
        Seller seller = (Seller) ac.getBean("seller");
        waiter.greetTo("Join");
        seller.greetTo("Join");
    }

    public void Test01(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory pd = new ProxyFactory();
        pd.setTarget(target);
        pd.addAdvice(advice);

        Waiter proxy = (Waiter)pd.getProxy();
        proxy.greetTo("John");
    }

    public void Test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter7.xml");
        Waiter waiter = (Waiter) ac.getBean("waiter");
        waiter.greetTo("Join");
    }

    public void Test03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter7.xml");
        NaiveWaiter waiter = (NaiveWaiter) ac.getBean("waiter");
        Seller seller = (Seller) ac.getBean("seller");
        waiter.greetTo("Join");
        waiter.serveTo("Join");
        System.out.println("-------------------");
        seller.greetTo("Join");
    }


}

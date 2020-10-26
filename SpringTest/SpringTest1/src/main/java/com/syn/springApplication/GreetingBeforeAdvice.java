package com.syn.springApplication;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String)objects[0];
        System.out.println("How are you! Mr."+clientName+".");
    }

    public static void main(String[] args) {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory pd = new ProxyFactory();
        pd.setTarget(target);
        pd.addAdvice(advice);

        Waiter proxy = (Waiter)pd.getProxy();
        proxy.greetTo("John");
    }
}

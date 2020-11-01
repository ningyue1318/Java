package com.syn.springApplication.chapter8;

import com.syn.springApplication.chapter7.NeedTest;
import com.syn.springApplication.chapter7.Waiter;
import org.springframework.stereotype.Component;

@Component("waiter")
public class NaiveWaiter implements Waiter {
    @NeedTest
    @Override
    public void greetTo(String name) {
        System.out.println("NaiveWaiter:greet to"+name+"...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("NaiveWaiter:serving "+name+"...");
    }
}

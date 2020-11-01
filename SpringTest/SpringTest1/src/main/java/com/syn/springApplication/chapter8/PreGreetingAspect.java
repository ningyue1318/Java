package com.syn.springApplication.chapter8;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PreGreetingAspect {

    @Before("@annotation(com.syn.springApplication.chapter7.NeedTest)")
    public void beforeGreeting(){
        System.out.println("How are you");
    }
}

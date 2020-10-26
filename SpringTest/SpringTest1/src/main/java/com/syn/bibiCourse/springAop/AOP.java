package com.syn.bibiCourse.springAop;


import org.junit.Before;
import org.springframework.stereotype.Component;

@Component
public class AOP {

    @Before()
    public void begin(){
        System.out.println("开始事物");
    }
}

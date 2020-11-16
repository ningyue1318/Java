package com.syn.bibiCourse.Spring.ext;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class LogAspects {

    @Pointcut("execution(* com.syn.bibiCourse.ext.MathCalculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void logStart(){
        System.out.println("除法运行，参数列表是");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("除法正常返回，运行结果是");
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("除法异常");
    }


}

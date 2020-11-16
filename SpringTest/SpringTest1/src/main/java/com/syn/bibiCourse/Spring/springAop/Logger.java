package com.syn.bibiCourse.Spring.springAop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void beforePrintLog(){
        System.out.println("before打印了日志");
    }

    public void afterReturningPrintLog(){
        System.out.println("afterReturningPrintLog打印了日志");
    }

    public void afterThrowingPrintLog(){
        System.out.println("afterThrowingPrintLog打印了日志");
    }

    public void afterPrintLog(){
        System.out.println("afterPrintLog打印了日志");
    }

    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        try {
            System.out.println("前置通知");
            Object[] args = pjp.getArgs();
            System.out.println("后置通知");
            Object rtValue = pjp.proceed(args);
            return rtValue;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知");
        }finally {
            System.out.println("最终通知");
        }
        return null;
    }
}

package com.syn.springApplication.chapter7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PerformanceHandler implements InvocationHandler {
    private Object target;

    public PerformanceHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target.getClass().getName()+"#"+method.getName());
        Object obj = method.invoke(target,args);
        System.out.println("结束调用");
        return obj;
    }

    public static void main(String[] args) {
        Service s = new ServiceImp();
        PerformanceHandler handler = new PerformanceHandler(s);

        Service proxy = (Service) Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                handler
        );

        proxy.removeForum();
        proxy.removeTopic();
    }
}

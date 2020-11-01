package com.syn.springApplication.chapter7;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib开始动态代理");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("结束Cglib动态代理");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ServiceImp serviceImp= (ServiceImp) proxy.getProxy(ServiceImp.class);
        serviceImp.removeForum();
        serviceImp.removeTopic();
    }
}

package com.syn.geekband.chapterbefore3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory  {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }




}

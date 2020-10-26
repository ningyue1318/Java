package com.syn.bibiCourse.springAop;

import com.syn.bibiCourse.springDemo.Dao.Account;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer en = new Enhancer();

        en.setSuperclass(target.getClass());

        en.setCallback(this);

        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事物。。。。");

        methodProxy.invokeSuper(o,objects);

        System.out.println("提交事物");
        return null;
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.setId(1);
        Account factory = (Account)new ProxyFactory(account).getProxyInstance();

        factory.getId();
    }
}

package com.syn.geekband.chapter4;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserFactory implements InitializingBean, DisposableBean {

    @PostConstruct
    public User createUser(){
        System.out.println("@PostConstruct:UserFactory 初始化中。。。");
        return User.createUser();
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory():UserFactory 初始化中。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean:UserFactory 初始化中。。。");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@preDestroy:UserFactory销毁中");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy:UserFactory销毁中");
    }


    public void doDestroy(){
        System.out.println("自定义销毁方法");
    }
}

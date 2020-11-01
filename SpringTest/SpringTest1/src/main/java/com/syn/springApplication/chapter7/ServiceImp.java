package com.syn.springApplication.chapter7;

public class ServiceImp implements Service{
    @Override
    public void removeTopic() {
        System.out.println("执行了removeTopic方法");
    }

    @Override
    public void removeForum() {
        System.out.println("执行了removeForum方法");
    }
}

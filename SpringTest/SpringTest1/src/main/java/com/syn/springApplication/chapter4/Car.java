package com.syn.springApplication.chapter4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("v2-调用Car()构造函数");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand){
        System.out.println("v5-调用setBrand（）设置属性");
        this.brand = brand;
    }

    public void introduce(){
        System.out.println("brand:"+brand+";color"+color+";maxSpeed:"+maxSpeed);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("v7-调用BeanFactoryAware.setBeanFactory().");
        this.beanFactory=beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("v6-调用BeanNameAware.setBeanName()");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("v12-调用DisposableBean.destroy().");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("v9-调用InitializingBean.afterPropertiesSet().");
    }

    public void myInit(){
        System.out.println("v10-调用init-method方法指定的myInit（）,将maxSpeed设置240.");
        this.maxSpeed = 240;
    }

    public void myDestroy(){
        System.out.println("v13-调用destroy-method所指定的myDestroy().");
    }
}

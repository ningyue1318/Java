package com.syn.springApplication.chapter4;

import org.springframework.beans.BeansException;

public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getColor()==null){
                System.out.println("v8-调用BeanPostProcessor。postProcessBeforeInitialization，color为空，设置为默认黑色");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getMaxSpeed()>=200){
                System.out.println("v11-调用BeanPostProcessor。postProcessAfterInitialization，color为空，设置为默认黑色");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}

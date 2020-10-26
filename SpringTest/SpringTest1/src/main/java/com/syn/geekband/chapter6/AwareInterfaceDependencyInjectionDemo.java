package com.syn.geekband.chapter6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware {
    private  static BeanFactory beanFactory;

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareInterfaceDependencyInjectionDemo.class);


        applicationContext.refresh();

        System.out.println(beanFactory == applicationContext.getBeanFactory());
        System.out.println(applicationContext == applicationContext.getBeanFactory());

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }
}

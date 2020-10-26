package com.syn.geekband.chapter5;

import com.syn.geekband.chapterbefore3.User;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        applicationContext.refresh();
        //演示BeanFactory getBean方法的安全性
        displayBeanFactoryGetBean(applicationContext);
        
        //演示ObjectFactory getObject方法的安全性
        displayObjectFactoryGetBean(applicationContext);

        //演示ObjectProvider getIfAvaiable方法的安全性
        displayObjectProviderIfAvailable(applicationContext);

        displayListableBeanFactory(applicationContext);

        applicationContext.close();
    }

    private static void displayListableBeanFactory(ListableBeanFactory applicationContext) {
        printBeansException("displayListableBeanFactory",()->applicationContext.getBeansOfType(User.class));
    }

    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderIfAvailable",()->userObjectFactory.getIfAvailable());
    }

    private static void displayObjectFactoryGetBean(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject",()->userObjectFactory.getObject());
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory){
        printBeansException("displayBeanFactoryGetBean",()->{
            beanFactory.getBean(User.class);
        });
    }

    private static void printBeansException(String source, Runnable runnable){
        System.err.println(source);
        try{
            runnable.run();
        }catch (BeansException exception){
            exception.printStackTrace();
        }
    }
}

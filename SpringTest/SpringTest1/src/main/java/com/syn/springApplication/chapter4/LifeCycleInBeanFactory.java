package com.syn.springApplication.chapter4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LifeCycleInBeanFactory {
    public static void main(String[] args) {
        Resource res = new ClassPathResource("META-INF/bean7.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);


        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new BeanPostProcessor());

        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car)bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        Car car2 = (Car)bf.getBean("car");
        System.out.println("car1==car2:"+(car1==car2));
        ((DefaultListableBeanFactory)bf).destroySingletons();
    }
}

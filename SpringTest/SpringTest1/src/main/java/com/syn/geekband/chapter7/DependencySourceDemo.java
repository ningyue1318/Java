package com.syn.geekband.chapter7;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.io.ResourceLoader;
import sun.applet.AppletEventMulticaster;

import javax.annotation.PostConstruct;

public class DependencySourceDemo {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher appletEventMulticaster;


    @PostConstruct
    public void init(){
        System.out.println("beanFactory == applicationContext "+(beanFactory==applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory() "+(beanFactory==applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext "+(resourceLoader==applicationContext));
        System.out.println("appletEventMulticaster == applicationContext "+(appletEventMulticaster==applicationContext));
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencySourceDemo.class);

        applicationContext.refresh();

        DependencySourceDemo demo = applicationContext.getBean(DependencySourceDemo.class);

        applicationContext.close();
    }
}

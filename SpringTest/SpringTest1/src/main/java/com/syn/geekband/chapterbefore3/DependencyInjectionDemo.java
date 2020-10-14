package com.syn.geekband.chapterbefore3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserRepository userRepository =(UserRepository)beanFactory.getBean("userRepository");
        System.out.println(userRepository.getUsers());

        System.out.println(userRepository.getBeanFactory()==beanFactory);

    }
}

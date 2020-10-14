package com.syn.geekband.chapter4;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean.xml");
        User user = beanFactory.getBean("user-by-static-method",User.class);
        User user1 = beanFactory.getBean("user-by-instance-method",User.class);
        User user2 = beanFactory.getBean("user-by-factory-bean",User.class);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user==user1);




    }
}

package com.syn.geekband.chapterbefore3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookUpDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找 "+user);

        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user1 = objectFactory.getObject();
        System.out.println("延迟查找 "+user1);

        User user2 = beanFactory.getBean(User.class);
        System.out.println("按照类型查找 "+user2);

        ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
        Map<String,User> users =listableBeanFactory.getBeansOfType(User.class);
        System.out.println("查找到所有的User对象"+users);

        ListableBeanFactory listableBeanFactory1 = (ListableBeanFactory)beanFactory;
        Map<String, User> users1 = (Map)listableBeanFactory1.getBeansWithAnnotation(Super.class);
        System.out.println("注解查找的User对象"+users1);


    }
}

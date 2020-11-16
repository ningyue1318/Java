package com.syn.bibiCourse.Spring.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter3.xml");
        UserService userService = (UserService)ac.getBean("userService");
        userService.save();
    }
}

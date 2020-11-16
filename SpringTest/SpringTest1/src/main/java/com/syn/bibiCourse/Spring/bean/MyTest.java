package com.syn.bibiCourse.Spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        String [] definitionNames = ac.getBeanDefinitionNames();
        for(String s:definitionNames){
            System.out.println(s);
        }
    }
}

package com.syn.geekband.chapter6;


import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.stream.Collectors;

public class QualifierAnnotationDependencyInjectionDemo {

    //整体应用上下文存在4个User类型的Bean;
    //SuperUser
    //user
    //user1
    //user2
    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User namedUser;

    @Bean
    @Qualifier
    public User user1(){
        User user = new User();
        user.setId(7L);
        return user;
    }

    @Bean
    @Qualifier
    public User user2(){
        User user = new User();
        user.setId(8L);
        return user;
    }

    @Autowired
    private Collection<User> allUser;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        beanDefinitionReader.loadBeanDefinitions("META-INF/bean6.xml");

        applicationContext.refresh();

        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);


        System.out.println("demo.user ="+demo.user);
        System.out.println("demo.namedUser = "+demo.namedUser);

        System.out.println("demo.allUsers ="+demo.allUser);
        System.out.println("demo.qualifiedUsers = "+demo.qualifiedUsers);
        applicationContext.close();
    }
}

package com.syn.geekband.chapter4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
    public UserFactory userFactory(){
        return new UserFactory();
    }

}

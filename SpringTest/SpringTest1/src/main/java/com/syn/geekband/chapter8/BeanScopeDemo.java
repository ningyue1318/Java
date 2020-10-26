package com.syn.geekband.chapter8;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeanScopeDemo {

    @Bean
    public static User singletonUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return  user;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return  user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanScopeDemo.class);

        applicationContext.refresh();
        
        scopedBeanByLookup(applicationContext);

        applicationContext.close();

    }

    private static void scopedBeanByLookup(AnnotationConfigApplicationContext applicationContext) {
        for(int i=0;i<3;i++){
            User singletonUser = applicationContext.getBean("singletonUser",User.class);
            System.out.println("singletonUser = " +singletonUser);

            User prototypeUser = applicationContext.getBean("prototypeUser",User.class);
            System.out.println("prototypeUser = "+prototypeUser);
        }
    }
}

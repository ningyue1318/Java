package com.syn.geekband.chapter5;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);

        applicationContext.refresh();
        try{
            //由于String应用上下文中存在两个String类型的Bean，通过单一类型查找会抛出异常
            applicationContext.getBean(String.class);

        }catch (NoUniqueBeanDefinitionException e){
            System.err.printf("Spring 应用上下文存在 %d 个%s类型的bean，具体原因：%s",e.getNumberOfBeansFound(),String.class.getName(),e.getMessage());
        }

        applicationContext.close();
    }

    @Bean
    public String bean1(){
        return "bean1";
    }

    @Bean
    public String bean2(){
        return "bean1";
    }
}

package com.syn.geekband.chapter4;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;


@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration （配置类）
        applicationContext.register(Config.class);

        registerBeanDefinition(applicationContext,"mercyblitz-use",User.class);
        registerBeanDefinition(applicationContext,null,User.class);
        applicationContext.refresh();
        //1. @Bean方式定义
        //2. @Component方式
        //3. @Import方式
        Map<String, Config> configMap = applicationContext.getBeansOfType(Config.class);
        System.out.println("Config 类型的所有 Beans"+applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans"+applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry,String beanName,Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("id",1L);
        beanDefinitionBuilder.addPropertyValue("name","小马哥");

        if(StringUtils.hasText(beanName)){
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }else{
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }

    }



    @Component
    public static class Config{

        @Bean(name={"user","xiaomage-user"})
        public User user(){
            User user = new User();
            user.setId(1L);
            user.setName("小马哥");
            return user;
        }
    }
}

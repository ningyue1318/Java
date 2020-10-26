package com.syn.geekband.chapter10;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ObjectUtils;

public class BeanConfigurationMetadataDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","mercyblitz");
        BeanDefinition bd = beanDefinitionBuilder.getBeanDefinition();
        bd.setAttribute("name","小马哥");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(ObjectUtils.nullSafeEquals("user",beanName)&&User.class.equals(bean.getClass())){
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    System.out.println(bd.getAttribute("name"));
                    User usr = (User)bean;
                    usr.setName((String)bd.getAttribute("name"));
                }
                return bean;
            }
        });

        beanFactory.registerBeanDefinition("user",bd);

        User user = (User)beanFactory.getBean("user");
        System.out.println(user);
    }
}

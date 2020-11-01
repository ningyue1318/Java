package com.syn.bibiCourse.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor#postProcessBeanFactory执行");
        System.out.println(beanFactory.getBeanDefinitionCount());
        String [] beanNames = beanFactory.getBeanDefinitionNames();
        for(String name :beanNames){
            System.out.println(name);
        }
    }
}

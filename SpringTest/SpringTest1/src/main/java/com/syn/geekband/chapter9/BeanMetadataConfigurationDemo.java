package com.syn.geekband.chapter9;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

public class BeanMetadataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        EncodedResource resource = new EncodedResource(new ClassPathResource("META-INF/user.properties"),"GBK");
        int beanNumbers = propertiesBeanDefinitionReader.loadBeanDefinitions(resource);
        System.out.println(beanNumbers);

        User user = beanFactory.getBean("user",User.class);
        System.out.println(user);
    }
}

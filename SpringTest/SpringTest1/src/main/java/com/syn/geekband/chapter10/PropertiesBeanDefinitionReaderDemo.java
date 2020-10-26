package com.syn.geekband.chapter10;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

public class PropertiesBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource= resourceLoader.getResource("META-INF/user.properties");
        EncodedResource encodedResource = new EncodedResource(resource,"GBK");

        int beanDefinitionCount =beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("已经加载个数："+beanDefinitionCount);

        User usr = beanFactory.getBean("user",User.class);
        System.out.println(usr);
    }
}

package com.syn.geekband.chapter5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前BeanFactory的Parent BeanFactory： "+beanFactory.getParentBeanFactory());

        beanFactory.setParentBeanFactory(createParentBeanFactory());
        System.out.println("当前BeanFactory的Parent BeanFactory： "+beanFactory.getParentBeanFactory());

      
        applicationContext.refresh();
        applicationContext.close();
    }

    private static void displayLocalBean(HierarchicalBeanFactory beanFactory,String beanName){
        System.out.printf("当前BeanFactory [%s] 是否包含bean[name:%s],%s\n",beanFactory,beanName,beanFactory.containsLocalBean(beanName));


    }

    private static BeanFactory createParentBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanDefinitionsCount = reader.loadBeanDefinitions("META-INF/bean.xml");
        return beanFactory;
    }
}

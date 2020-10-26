package com.syn.geekband.chapter6;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApiDependencySetterInjection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition beanDefinition = createUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder",beanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("META-INF/bean6.xml");

        applicationContext.refresh();


        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        applicationContext.close();
    }

    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addPropertyReference("user","superUser");

        return  definitionBuilder.getBeanDefinition();
    }
}

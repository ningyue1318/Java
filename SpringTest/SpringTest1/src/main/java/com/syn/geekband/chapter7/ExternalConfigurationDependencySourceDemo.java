package com.syn.geekband.chapter7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("META-INF/default.properties")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${user.resource:null}")
    private Resource resource;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);

        applicationContext.refresh();

        ExternalConfigurationDependencySourceDemo dependencySourceDem = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println(dependencySourceDem.id);
        System.out.println(dependencySourceDem.resource);
        applicationContext.close();
    }
}

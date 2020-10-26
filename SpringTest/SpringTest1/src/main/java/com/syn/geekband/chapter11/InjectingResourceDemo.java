package com.syn.geekband.chapter11;

import com.syn.geekband.chapter11.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class InjectingResourceDemo {

    @Value("classpath://META-INF/user.properties")
    private Resource defaultPropertiesResource;

    @PostConstruct
    public void init(){
        System.out.println();
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingResourceDemo.class);

        context.refresh();
        context.close();
    }
}

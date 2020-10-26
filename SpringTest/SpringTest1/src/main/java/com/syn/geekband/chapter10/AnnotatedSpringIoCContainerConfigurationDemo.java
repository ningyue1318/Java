package com.syn.geekband.chapter10;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.Map;

@ImportResource("META-INF/bean7.xml")
@Import(User.class)
public class AnnotatedSpringIoCContainerConfigurationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedSpringIoCContainerConfigurationDemo.class);

        context.refresh();
        Map<String,User> userMap = context.getBeansOfType(User.class);
        for(Map.Entry<String,User> entry:userMap.entrySet()){
            System.out.printf("User Bean name:%s,content:\n",entry.getKey(),entry.getValue());
        }
        context.close();
    }
}

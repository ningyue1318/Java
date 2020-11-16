package com.syn.bibiCourse.Spring.bean;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Configuration
@ComponentScan(value = "com.syn.bibiCourse.Spring.bean",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
@Import(HashMap.class)
public class MainConfig {

    @Bean
    public Person person(){
        return new Person("lisi",20);
    }
}

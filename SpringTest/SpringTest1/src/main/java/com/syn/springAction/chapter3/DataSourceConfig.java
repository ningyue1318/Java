package com.syn.springAction.chapter3;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public User getUser1(){
        User user = new User();
        user.setName("dev");
        user.setId(1L);
        return user;
    }

    @Bean
    @Profile("prod")
    public User getUser2(){
        User user = new User();
        user.setName("prod");
        user.setId(2L);
        return user;
    }


}

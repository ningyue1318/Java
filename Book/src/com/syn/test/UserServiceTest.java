package com.syn.test;

import com.syn.pojo.User;
import com.syn.service.UserService;
import com.syn.service.impl.UserServiceImpl;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User("admin1","12","1"));
    }

    @Test
    public void login() {
        User user = new User();
        user.setUsername("admin");
        userService.login(user);
    }

    @Test
    public void existUsername() {
        System.out.println(userService.existUsername("admin2"));
    }
}
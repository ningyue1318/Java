package com.syn.bibiCourse.Spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(){
        userDao.save();
        int i =1/0;
        userDao.save();

    }
}

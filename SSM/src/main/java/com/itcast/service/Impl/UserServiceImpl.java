package com.itcast.service.Impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        System.out.println("业务层：查询所有的账户");
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        System.out.println("业务层：保存了账户");
    }
}

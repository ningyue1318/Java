package com.syn.service.impl;

import com.syn.dao.UserDao;
import com.syn.dao.impl.UserDaoImpl;
import com.syn.pojo.User;
import com.syn.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}

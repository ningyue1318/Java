package com.itheima.Dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Integer userId);

}

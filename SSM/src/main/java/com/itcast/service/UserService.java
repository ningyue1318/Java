package com.itcast.service;

import com.itcast.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public void saveUser(User user);
}

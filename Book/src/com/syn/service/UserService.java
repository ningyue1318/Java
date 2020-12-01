package com.syn.service;

import com.syn.pojo.User;

public interface UserService {
    public void registerUser(User user);

    public User login(User user);

    public boolean existUsername(String username);
}

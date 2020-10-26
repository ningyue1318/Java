package com.syn.geekband.chapter6;

import com.syn.geekband.chapterbefore3.User;

public class UserHolder {
    private User user;

    public UserHolder(){
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }

}

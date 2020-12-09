package com.itcast.dao;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from t_user")
    public List<User> findAll();


    public void saveUser(User user);

}

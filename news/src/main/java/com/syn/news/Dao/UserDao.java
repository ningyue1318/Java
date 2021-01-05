package com.syn.news.Dao;

import com.syn.news.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    @Insert("insert into `user` (`name`,`password`,salt,head_url) values (#{name},#{password},#{salt},#{headUrl})")
    int addUser(User user);

    @Select("select name,password,salt,head_url from `user` where id = #{id}")
    User selectById(int id);

    @Update("update `user` set password=#{password} where id = #{id}")
    void updatePassword(User user);

    @Select("select id,name,password,salt,head_url from `user` where name = #{username}")
    User selectByName(String username);

}

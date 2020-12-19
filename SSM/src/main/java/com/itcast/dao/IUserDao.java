package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "uPassword"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "uStatus"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itcast.dao.IRoleDao.findRoleByUser")),

    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "uPassword"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "uStatus"),
    })
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,uPassword,phoneNum,uStatus) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "uPassword"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "uStatus"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itcast.dao.IRoleDao.findRoleByUser")),
    })
    UserInfo findById(Integer id) throws Exception;


    @Select("select * from roles where id not in (select roleId from users_roles where userId=#{userId})")
    List<Role> findOtherRoles(Integer userId);

    @Insert("insert into users_roles(userId,roleId) value(#{userId},#{id})")
    void addRoleToUser(@Param("userId") Integer userId,@Param("id") Integer id);
}

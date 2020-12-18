package com.itcast.dao;

import com.itcast.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    @Select("select * from roles where id in(select roleId from users_roles where userId=#{userId})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itcast.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role>  findRoleByUser(String userId) throws Exception;


    @Select("select * from roles")
    List<Role> findAll() throws Exception;
}

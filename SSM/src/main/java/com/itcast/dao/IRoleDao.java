package com.itcast.dao;

import com.itcast.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    @Select("select * from roles where id in(select roleId from users_roles where userId=#{userId})")
    public List<Role>  findRoleByUser(String userId) throws Exception;
}

package com.itcast.dao;

import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import org.apache.ibatis.annotations.*;
import org.omg.PortableInterceptor.INACTIVE;

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

    @Insert("insert into roles(roleName,roleDesc) value(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from roles where id =#{roleId}")
    Role findById(Integer roleId) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) value(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId) throws Exception;
}

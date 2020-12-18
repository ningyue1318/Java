package com.itcast.dao;

import com.itcast.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(Integer id) throws Exception;
}

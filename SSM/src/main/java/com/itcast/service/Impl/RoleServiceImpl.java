package com.itcast.service.Impl;

import com.itcast.dao.IRoleDao;
import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.service.IRoleService;
import org.apache.ibatis.annotations.Select;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissions) throws Exception {
        for(Integer id:permissions){
            roleDao.addPermissionToRole(roleId,id);
        }
    }
}

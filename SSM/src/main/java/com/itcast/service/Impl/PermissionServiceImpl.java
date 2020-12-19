package com.itcast.service.Impl;

import com.itcast.dao.IPermissionDao;
import com.itcast.dao.IProductDao;
import com.itcast.domain.Permission;
import com.itcast.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    IPermissionDao dao;

    @Override
    public List<Permission> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        dao.save(permission);
    }
}

package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;
}

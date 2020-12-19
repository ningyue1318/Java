package com.itcast.service;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;

    List<Role> findOtherRoles(Integer userId) throws Exception;

    void addRoleToUser(Integer userId, Integer[] rolesIds) throws Exception;
}

package com.itheima.Dao;

import com.itheima.domain.AccountUser;
import com.itheima.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class RoleDaoTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initFactory() throws IOException {
        String config_class = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config_class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);

        List<Role> roles = roleDao.findAll();
        for(Role a:roles){
            System.out.println(a);
        }
    }
}
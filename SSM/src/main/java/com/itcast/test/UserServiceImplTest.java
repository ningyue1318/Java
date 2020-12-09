package com.itcast.test;


import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import com.itcast.service.Impl.UserServiceImpl;
import com.itcast.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserServiceImplTest {

    @Test
    public void findAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList=mapper.findAll();
        System.out.println(userList);
        sqlSession.close();
        in.close();
    }

    @Test
    public void saveUser() {
    }
}
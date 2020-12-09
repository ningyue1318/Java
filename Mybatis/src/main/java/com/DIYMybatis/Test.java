package com.DIYMybatis;

import com.itheima.Dao.UserDao;
import com.itheima.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        String config_class = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config_class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> users =userDao.findAll();
        for(User u:users){
            System.out.println(u);
        }
    }
}

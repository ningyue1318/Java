package com.itheima.Dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import com.itheima.domain.User;
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

public class AccountDaoTest {

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
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<AccountUser> accounts = accountDao.findAll();
        for(AccountUser a:accounts){
            System.out.println(a);
            System.out.println(a.getUser());
        }
    }


    @Test
    public void findAllAccountUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<AccountUser> accounts = accountDao.findAllAccount();
        for(AccountUser a:accounts){
            System.out.println(a);
        }
    }
}
package com.itcast.test;

import com.itcast.dao.IProductDao;
import com.itcast.dao.IUserDao;
import com.itcast.domain.Product;
import com.itcast.domain.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class IProductDaoTest {

    @Test
    public void save() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao dao = ac.getBean(IUserDao.class);
        UserInfo u = new UserInfo();
        u.setUsername("123");
        u.setPassword("123");
        u.setEmail("123@qq");
        u.setPhoneNum("123456");
        u.setStatus(1);
        dao.save(u);
        System.out.println(u);
    }
}
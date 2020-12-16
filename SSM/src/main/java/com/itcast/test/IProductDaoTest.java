package com.itcast.test;

import com.itcast.dao.IProductDao;
import com.itcast.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class IProductDaoTest {

    @Test
    public void save() throws Exception {
        Product p = new Product();
        p.setCityName("广州");
        p.setProductName("itcast-004");
        p.setProductNum("1000");
        p.setProductDesc("北京");
        p.setProductStatus(1);
        p.setDepartureTime(new Date());
        p.setProductName("123");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IProductDao dao = ac.getBean(IProductDao.class);
        dao.save(p);
    }
}
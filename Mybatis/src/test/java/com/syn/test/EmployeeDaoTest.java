package com.syn.test;

import com.syn.bean.Employee;
import com.syn.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    @Test
    public void test() throws IOException {
        /*
            SqlSessionFactory,是SqlSession工厂，负责创建SqlSession对象
            SqlSession:sql会话，代表和数据库的一次会话
         */
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.getEmpById(1);
        System.out.println(employee);
    }
}
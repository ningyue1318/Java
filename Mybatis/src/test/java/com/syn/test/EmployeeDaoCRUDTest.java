package com.syn.test;

import com.syn.bean.Employee;
import com.syn.bean.Key;
import com.syn.bean.Lock;
import com.syn.dao.EmployeeDao;
import com.syn.dao.KeyDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class EmployeeDaoCRUDTest {

    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }
    @Test
    public void getEmpById() throws IOException {
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao dao = openSession.getMapper(EmployeeDao.class);
        System.out.println(dao.getEmpById(1));
        openSession.close();
    }

    @Test
    public void updateEmployee() {
    }

    @Test
    public void deleteEmployee() {
    }

    @Test
    public void insertEmployee() {
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(null,"tomcat","tomcat@qq.com",1);
        int i = mapper.insertEmployee(employee);
        System.out.println(i);
        System.out.println(employee.getId());
        openSession.commit();
        openSession.close();
    }

    @Test
    public void insertEmployee2(){
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(null,"tomcat","tomcat@qq.com",1);
        int i = mapper.insertEmployee2(employee);
        System.out.println(i);
        System.out.println(employee.getId());
        openSession.commit();
        openSession.close();
    }

    @Test
    public void getEmpByIdAndEmpName(){
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
        Employee admin = mapper.getEmpByIdAndEmpName(1, "admin");
        System.out.println(admin);

        openSession.commit();
        openSession.close();
    }

    @Test
    public void getAllEmps(){
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);

        Map<Integer,Object> e=mapper.getAllEmps();
        System.out.println(e);
        Employee a = (Employee) e.get(1);
        System.out.println(a.getEmpName());
        openSession.commit();
        openSession.close();
    }


    @Test
    public void test04(){
        SqlSession openSession = sqlSessionFactory.openSession();
        KeyDao mapper = openSession.getMapper(KeyDao.class);

        Key keyByIdSimple = mapper.getKeyByIdSimple(1);
        System.out.println(keyByIdSimple.getKeyName());

        openSession.commit();
        openSession.close();
    }
}
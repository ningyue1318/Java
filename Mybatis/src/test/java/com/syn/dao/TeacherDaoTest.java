package com.syn.dao;

import com.syn.bean.Employee;
import com.syn.bean.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherDaoTest {

    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void getTeacherById() {
        SqlSession openSession = sqlSessionFactory.openSession();

        SqlSession os1 = sqlSessionFactory.openSession();
        TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);

        Teacher t = teacherDao.getTeacherById(1);
        System.out.println(t);
        Teacher t1 = teacherDao.getTeacherById(1);
        System.out.println(t1);

        TeacherDao t2 = os1.getMapper(TeacherDao.class);
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("update");
        t2.updateTeacher(teacher);

        Teacher t3 = teacherDao.getTeacherById(1);
        System.out.println(t3);

        openSession.commit();
        openSession.close();
    }
}
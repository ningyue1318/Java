package com.syn.springApplication.chapter13;

import com.syn.springApplication.chapter13.Dao.ForumDao;
import com.syn.springApplication.chapter13.domain.Forum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter13.xml");
        ForumDao dao = (ForumDao)ac.getBean("forumDao");
        dao.Test();
    }
}

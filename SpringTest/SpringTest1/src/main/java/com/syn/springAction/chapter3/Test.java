package com.syn.springAction.chapter3;

import com.syn.geekband.chapterbefore3.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
@ActiveProfiles("prod")
public class Test {

    @Autowired
   private User user;

    @Autowired
    private Dessert dessert;

    public static void main(String[] args) {

    }

    @org.junit.Test
    public void TestMethod(){
        System.out.println(dessert.getClass().getName());
    }
}

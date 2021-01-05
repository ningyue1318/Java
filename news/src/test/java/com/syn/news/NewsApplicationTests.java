package com.syn.news;

import com.syn.news.Dao.LoginTicketDao;
import com.syn.news.Dao.NewsDao;
import com.syn.news.Dao.UserDao;
import com.syn.news.Model.LoginTicket;
import com.syn.news.Model.News;
import com.syn.news.Model.User;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NewsApplication.class)
public class NewsApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    NewsDao newsDao;

    @Autowired
    LoginTicketDao loginTicketDAO;


    @Test
    public void initNews(){
//        Random random = new Random();
//        for (int i = 3; i < 11; ++i) {
//            LoginTicket ticket = new LoginTicket();
//            ticket.setStatus(0);
//            ticket.setUserId(i+1);
//            Date date = new Date();
//            ticket.setExpired(date);
//            ticket.setTicket(String.format("TICKET%d", i+1));
//            loginTicketDAO.addTicket(ticket);
//
//            loginTicketDAO.updateStatus(ticket.getTicket(), 2);
//        }

        Assert.assertEquals(4, loginTicketDAO.selectByTicket("TICKET4").getUserId());
        Assert.assertEquals(2, loginTicketDAO.selectByTicket("TICKET5").getStatus());
    }

}

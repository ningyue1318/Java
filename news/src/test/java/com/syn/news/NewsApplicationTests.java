package com.syn.news;

import com.syn.news.Dao.CommentDao;
import com.syn.news.Dao.LoginTicketDao;
import com.syn.news.Dao.NewsDao;
import com.syn.news.Dao.UserDao;
import com.syn.news.Model.*;


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

    @Autowired
    CommentDao commentDao;


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
//
//        Assert.assertEquals(4, loginTicketDAO.selectByTicket("TICKET4").getUserId());
//        Assert.assertEquals(2, loginTicketDAO.selectByTicket("TICKET5").getStatus());
//        for(int i=3;i<11;i++){
//            for(int j = 0; j < 3; ++j) {
//                Comment comment = new Comment();
//                comment.setUserId(i+1);
//                comment.setCreatedDate(new Date());
//                comment.setStatus(0);
//                comment.setContent("这里是一个评论啊！" + String.valueOf(j));
//                comment.setEntityId(i+10);
//                comment.setEntityType(EntityType.ENTITY_NEWS);
//                commentDao.addComment(comment);
//            }
//        }

        Assert.assertNotNull(commentDao.selectByEntity(13,EntityType.ENTITY_NEWS).get(0));
     }

}

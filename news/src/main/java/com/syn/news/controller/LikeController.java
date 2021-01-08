package com.syn.news.controller;

import com.syn.news.Model.EntityType;
import com.syn.news.Model.HostHolder;
import com.syn.news.Model.News;
import com.syn.news.async.EventModel;
import com.syn.news.async.EventProducer;
import com.syn.news.async.EventType;
import com.syn.news.service.LikeService;
import com.syn.news.service.NewsService;
import com.syn.news.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {

    @Autowired
    HostHolder hostHolder;

    @Autowired
    LikeService likeService;

    @Autowired
    NewsService newsService;

    @Autowired
    EventProducer eventProducer;

    @RequestMapping(value = "/like",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String like(@RequestParam("newsId") int newsId){
        int userId = hostHolder.getUser().getId();
        long likeCount = likeService.like(userId, EntityType.ENTITY_NEWS,newsId);
        newsService.updateLikeCount(newsId,(int)likeCount);
        News news = newsService.getById(newsId);
        eventProducer.fireEvent(new EventModel(EventType.LIKE)
                .setActorId(hostHolder.getUser().getId())
                .setEntityId(newsId)
                .setEntityType(EntityType.ENTITY_NEWS)
                .setEntityOwnerId(news.getUserId()));
        return ToutiaoUtil.getJSONString(0,String.valueOf(likeCount));
    }

    @RequestMapping(value = "/dislike",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String dislike(@RequestParam("newsId") int newsId){
        int userId = hostHolder.getUser().getId();
        long likeCount = likeService.disLike(userId, EntityType.ENTITY_NEWS,newsId);
        newsService.updateLikeCount(newsId,(int)likeCount);
        return ToutiaoUtil.getJSONString(0,String.valueOf(likeCount));
    }

}

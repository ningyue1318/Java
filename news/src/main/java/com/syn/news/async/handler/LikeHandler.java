package com.syn.news.async.handler;

import com.syn.news.Model.Message;
import com.syn.news.Model.User;
import com.syn.news.async.EventHandler;
import com.syn.news.async.EventModel;
import com.syn.news.async.EventType;
import com.syn.news.service.MessageService;
import com.syn.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LikeHandler implements EventHandler {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        message.setFromId(model.getActorId());
        message.setToId(model.getActorId()); //测试用
        //message.setToId(model.getEntityOwnerId()); //实际功能
        User user = userService.getUser(model.getActorId());
        message.setContent("用户"+user.getName()+"赞了你的咨讯，http://127.0.0.1:8080/news/"+model.getEntityId());
        message.setCreatedDate(new Date());
        int fromId = message.getFromId();
        int toId = message.getToId();
        message.setConversationId(fromId<toId?String.format("%d_%d",fromId,toId):String.format("%d_%d",toId,fromId));
        messageService.addMessage(message);
        System.out.println("Liked");
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE);
    }
}

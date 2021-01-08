package com.syn.news.async.handler;

import com.syn.news.Model.Message;
import com.syn.news.async.EventHandler;
import com.syn.news.async.EventModel;
import com.syn.news.async.EventType;
import com.syn.news.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LoginExceptionHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Override
    public void doHandle(EventModel model) {
        System.out.println("处理登录");
        Message message = new Message();
        message.setToId(model.getActorId());
        message.setContent("你上次的登录ip异常");
        message.setFromId(0);
        message.setCreatedDate(new Date());
        message.setConversationId(String.format("%d_%d",0,message.getToId()));
        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}

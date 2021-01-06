package com.syn.news.controller;

import com.syn.news.Dao.MessageDao;
import com.syn.news.Model.*;
import com.syn.news.service.MessageService;
import com.syn.news.service.UserService;
import com.syn.news.util.ToutiaoUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    @RequestMapping(value = "/msg/addMessage",method = RequestMethod.POST)
    @ResponseBody
    public String addMessage(@RequestParam("fromId") int fromId,
                             @RequestParam("toId") int toId,
                             @RequestParam("content") String content){
        try{
            Message msg = new Message();
            msg.setContent(content);
            msg.setFromId(fromId);
            msg.setToId(toId);
            msg.setCreatedDate(new Date());
            msg.setConversationId(fromId<toId?String.format("%d_%d",fromId,toId):String.format("%d_%d",toId,fromId));
            messageService.addMessage(msg);
            return ToutiaoUtil.getJSONString(msg.getId());
        }catch (Exception e){
            System.out.println("添加对话失败"+e.getMessage());
        }
        return ToutiaoUtil.getJSONString(1,"添加对话失败");
    }

    @RequestMapping(value = "/msg/detail",method = RequestMethod.GET)
    public String conversationDetail(Model model, @Param("conversationId") String conversationId){
        try {
            List<Message> conversationList = messageService.getConversationDetail(conversationId, 0, 10);
            List<ViewObject> message = new ArrayList<>();
            for(Message msg:conversationList){
                ViewObject vo = new ViewObject();
                vo.set("message",msg);
                User user =  userService.getUser(msg.getFromId());
                if(user==null){
                    continue;
                }
                vo.set("headUrl",user.getHeadUrl());
                vo.set("userId",user.getId());
                message.add(vo);
            }
            model.addAttribute("messages",message);
        }catch (Exception e){
            System.out.println("获取详情页失败"+e.getMessage());
        }
        return "letterDetail";
    }


    @RequestMapping(value = "/msg/list",method = RequestMethod.GET)
    public String conversationList(Model model){
        try{
            int localUserId = hostHolder.getUser().getId();
            List<ViewObject> conversations = new ArrayList<>();
            List<Message> conversationList = messageService.getConversationList(localUserId,0,10);
            for(Message msg:conversationList){
                ViewObject vo = new ViewObject();
                vo.set("conversation",msg);
                int targetId = msg.getFromId()==localUserId?msg.getToId():msg.getFromId();
                User user = userService.getUser(targetId);
                vo.set("target",user);
                vo.set("unreadcount",messageService.getConversationUnreadCount(localUserId,msg.getConversationId()));
                conversations.add(vo);
            }
            model.addAttribute("conversations",conversations);
        }catch (Exception e){
            System.out.println("获取站内信列表失败"+e.getMessage());
        }
        return "letter";
    }


}

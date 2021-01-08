package com.syn.news.controller;

import com.syn.news.async.EventHandler;
import com.syn.news.async.EventModel;
import com.syn.news.async.EventProducer;
import com.syn.news.async.EventType;
import com.syn.news.service.UserService;
import com.syn.news.util.ToutiaoUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventProducer eventProducer;

    @RequestMapping(value = "/reg/",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String reg(Model model,
                      @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "rember",defaultValue = "0") int remember,
                      HttpServletResponse response){
        try {
            Map<String, Object> map = userService.register(username, password);
            if(map.containsKey("ticket")){
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                response.addCookie(cookie);
                if(remember>0){
                    cookie.setMaxAge(3600*24*5);
                }
                return ToutiaoUtil.getJSONString(0,"注册成功");
            }else{
                return ToutiaoUtil.getJSONString(1,map);
            }
        }catch (Exception e){
            System.out.println("注册异常"+e.getMessage());
            return ToutiaoUtil.getJSONString(1,"注册异常");
        }
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String login(Model model,
                      @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "rember",defaultValue = "0") int remember,
                        HttpServletResponse response){
        try {
            Map<String, Object> map = userService.login(username, password);
            if(map.containsKey("ticket")){
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                response.addCookie(cookie);
                if(remember>0){
                    cookie.setMaxAge(3600*24*5);
                }
                eventProducer.fireEvent(new EventModel(EventType.LOGIN)
                        .setActorId((int)map.get("userId"))
                        .setExt("username","牛客")
                        .setExt("eamil","ningyue@qq.com"));
                return ToutiaoUtil.getJSONString(0,"登录成功");
            }else{
                return ToutiaoUtil.getJSONString(1,map);
            }
        }catch (Exception e){
            System.out.println("登录异常"+e.getMessage());
            return ToutiaoUtil.getJSONString(1,"登录异常");
        }
    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
    public String logout(@CookieValue("ticket") String ticket){
        userService.logout(ticket);
        return "redirect:/";
    }

}

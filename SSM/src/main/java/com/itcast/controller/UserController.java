package com.itcast.controller;

import com.itcast.domain.UserInfo;
import com.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }


    @RequestMapping("save.do")
    public String save(UserInfo userInfo) throws Exception {
        System.out.println(userInfo);
        userService.save(userInfo);
        return "redirect:/user/findAll.do";
    }


    @RequestMapping("showAdd.do")
    public String showAdd(){
        System.out.println("user-add");
        return "user-add";
    }

}

package com.itcast.controller;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required = true) Integer userId) throws Exception {
        UserInfo userInfo = userService.findById(userId);
        List<Role> roles = userService.findOtherRoles(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="userId",required = true) Integer userId,
                                @RequestParam(name ="ids",required = true) Integer [] rolesIds) throws Exception {
        userService.addRoleToUser(userId,rolesIds);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("showAdd.do")
    public String showAdd(){
        System.out.println("user-add");
        return "user-add";
    }

}

package com.syn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandler {
    @RequestMapping("/handleException")
    public String handle01(Integer i){
        System.out.println("handle01被调用");
        System.out.println(10/i);
        return "success";
    }
/*
    @org.springframework.web.bind.annotation.ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleException(Exception e){
        System.out.println(e);
        System.out.println("错误页面");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("ex",e);
        return mv;
    }
*/

    @RequestMapping("/handleException2")
    public String handle02(@RequestParam("username") String username){
        if(!"admin".equals(username)){
            System.out.println("登录失败");
            throw new UserNameNotFoundException();
        }
        return "success";
    }

    @RequestMapping(value = "/handleException3",method = RequestMethod.POST)
    public String handle03(){
        return "success";
    }


}

@ResponseStatus(reason = "用户登录拒接",value = HttpStatus.NOT_ACCEPTABLE)
class UserNameNotFoundException extends RuntimeException{

}
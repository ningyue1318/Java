package com.syn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestMappingTestController {

    @RequestMapping("/hello")
    public String myFirstRequest(){
        System.out.println("目标方法执行了1");
        return "forward:/hello.jsp";
    }

    @RequestMapping("/hello1")
    public String myFirstRequest1(){
        System.out.println("目标方法执行了");
        return "redirect:/hello";
    }

    @RequestMapping(value = "/handle03")
    public String handle03(){
        return "success";
    }

    @RequestMapping(value = "/handle0?")
    public String handle04(){
        System.out.println("handle04");
        return "success";
    }

    //路径上可以有占位符，占位符语法就是任意路径的地方写一个{变量名}，路径上的占位符只能占用一层路径
    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "/handle05")
    public String handle05(String username,
                           @RequestHeader("User-agent") String userAgent,
                           @CookieValue("JSESSIONID") String id){
        System.out.println("handle05"+username);
        System.out.println(userAgent);
        System.out.println(id);
        return "success";
    }
}

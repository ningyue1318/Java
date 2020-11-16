package com.syn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;
@SessionAttributes(value = "msg")
@Controller
public class OutputController {


    @RequestMapping("/output/handle01")
    public String handler01(Map<String,Object> map){
        map.put("msg","你好");
        return "success";
    }
}

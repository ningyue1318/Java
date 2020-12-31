package com.syn.controller;

import com.syn.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam int a){
        throw new UserTooManyException();
        //return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(){

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}

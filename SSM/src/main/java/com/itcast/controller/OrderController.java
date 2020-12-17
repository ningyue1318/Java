package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Orders;
import com.itcast.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        List<Orders> ordersList = orderService.findAll();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
//

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                                @RequestParam(name ="size",required = true,defaultValue = "4") int size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("进入findById");
        Orders orders = orderService.findById(ordersId);
        mv.addObject("orders",orders);
        System.out.println(orders);
        mv.setViewName("orders-show");
        return mv;
    }
}

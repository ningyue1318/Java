package com.syn.test;

import com.syn.pojo.Cart;
import com.syn.pojo.CartItem;
import com.syn.service.OrderService;
import com.syn.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是："+orderService.createOrder(cart,1));
    }
}
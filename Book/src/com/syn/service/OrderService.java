package com.syn.service;

import com.syn.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}

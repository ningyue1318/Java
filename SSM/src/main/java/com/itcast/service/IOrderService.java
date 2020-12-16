package com.itcast.service;

import com.itcast.domain.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll() throws Exception;

    List<Orders> findAll(int page, int size) throws Exception;
}

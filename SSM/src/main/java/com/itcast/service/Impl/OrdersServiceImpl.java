package com.itcast.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.IOrdersDao;
import com.itcast.domain.Orders;
import com.itcast.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrderService {

    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll() throws Exception {
        PageHelper.startPage(1,5);
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }
}

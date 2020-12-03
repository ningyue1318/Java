package com.syn.test;

import com.syn.dao.OrderDao;
import com.syn.dao.impl.OrderDaoImpl;
import com.syn.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder(){
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567",new Date(),new BigDecimal(100),0,1));
    }
}
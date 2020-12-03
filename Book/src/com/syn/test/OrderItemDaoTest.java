package com.syn.test;

import com.syn.dao.OrderItemDao;
import com.syn.dao.impl.OrderItemDaoImpl;
import com.syn.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567"));

    }
}
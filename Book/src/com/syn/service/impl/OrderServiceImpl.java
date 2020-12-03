package com.syn.service.impl;

import com.syn.dao.BookDao;
import com.syn.dao.OrderDao;
import com.syn.dao.OrderItemDao;
import com.syn.dao.impl.BookDaoImpl;
import com.syn.dao.impl.OrderDaoImpl;
import com.syn.dao.impl.OrderItemDaoImpl;
import com.syn.pojo.*;
import com.syn.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();


    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis()+""+userId;

        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);

        orderDao.saveOrder(order);

        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);

            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();
        return orderId;
    }
}

package com.syn.web;

import com.syn.pojo.Cart;
import com.syn.pojo.User;
import com.syn.service.OrderService;
import com.syn.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User)req.getSession().getAttribute("user");

        if(loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart,userId);


        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}

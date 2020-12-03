package com.syn.web;

import com.syn.pojo.Book;
import com.syn.pojo.Cart;
import com.syn.pojo.CartItem;
import com.syn.service.BookService;
import com.syn.service.impl.BookServiceImpl;
import com.syn.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = req.getParameter("id")==null?0:Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastName",cartItem.getName());

        resp.sendRedirect(req.getHeader("Referer"));


    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = req.getParameter("id")==null?0:Integer.parseInt(req.getParameter("id"));
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cart cart = (Cart)req.getSession().getAttribute("cart");
       if(cart!=null) {
           cart.clear();
           resp.sendRedirect(req.getHeader("Referer"));
       }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = req.getParameter("id")==null?0:Integer.parseInt(req.getParameter("id"));
        int count = req.getParameter("count")==null?1:Integer.parseInt(req.getParameter("count"));
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}

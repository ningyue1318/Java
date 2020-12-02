package com.syn.web;

import com.syn.pojo.Book;
import com.syn.pojo.Page;
import com.syn.service.BookService;
import com.syn.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过了前台的Servlet程序");
        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = req.getParameter("pageSize")==null? Page.PAGE_SIZE :Integer.parseInt(req.getParameter("pageSize"));
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }


    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = req.getParameter("pageSize")==null? Page.PAGE_SIZE :Integer.parseInt(req.getParameter("pageSize"));
        int min = req.getParameter("min")==null?0:Integer.parseInt(req.getParameter("min"));
        int max = req.getParameter("max")==null?Integer.MAX_VALUE:Integer.parseInt(req.getParameter("max"));

        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }


        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}

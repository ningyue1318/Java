package com.syn.web;

import com.syn.pojo.Book;
import com.syn.pojo.Page;
import com.syn.service.BookService;
import com.syn.service.impl.BookServiceImpl;
import com.syn.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = req.getParameter("pageSize")==null? Page.PAGE_SIZE :Integer.parseInt(req.getParameter("pageSize"));
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        Page<Book> page = bookService.page(1,Page.PAGE_SIZE);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+page.getPageTotal());

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        bookService.deleteBookById(id);

        Page<Book> page = bookService.page(1,Page.PAGE_SIZE);

        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+page.getPageTotal());
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());

        bookService.updateBook(book);

        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();

        req.setAttribute("books",books);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了方法");
        Book book = bookService.queryBookById(Integer.parseInt(req.getParameter("id")));

        req.setAttribute("book",book);

        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

}

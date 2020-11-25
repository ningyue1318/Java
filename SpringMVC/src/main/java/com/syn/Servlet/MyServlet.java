package com.syn.Servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化"+new Date());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("执行了服务方法"+new Date());
        res.getWriter().write("Helloworld");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法执行"+new Date());
    }
}

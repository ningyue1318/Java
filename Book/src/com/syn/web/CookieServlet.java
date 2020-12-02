package com.syn.web;

import com.syn.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CookieServlet extends BaseServlet{

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        boolean isNew = session.isNew();
        String id = session.getId();
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("得到的Session的id是:"+id+"<br/>");
        resp.getWriter().write("得到的Session是否是新的:"+isNew+"<br/>");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.getWriter().write("Cookie="+ CookieUtils.findCookie("key1",cookies));

    }


}

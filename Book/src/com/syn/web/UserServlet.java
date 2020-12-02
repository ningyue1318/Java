package com.syn.web;

import com.syn.pojo.User;
import com.syn.service.UserService;
import com.syn.service.impl.UserServiceImpl;
import com.syn.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(username,password,""));
        if(loginUser==null){
            System.out.println("用户名或密码错误");
            req.setAttribute("msg","用户和密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {

            req.getSession().setAttribute("user",loginUser);

            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token =(String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());


        if(token!=null&&token.equalsIgnoreCase(code)){
            if(userService.existUsername(username)){
                req.setAttribute("msg","用户名已经存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                System.out.println("用户名["+username+"]已经存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registerUser(new User(username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else {
            System.out.println("验证码错误");
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getSession().invalidate();
       resp.sendRedirect(req.getContextPath());
    }




}

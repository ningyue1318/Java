package com.syn.test;

import com.syn.web.UserServlet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {

    public void login(){
        System.out.println("login");
    }

    public void regist(){
        System.out.println("regist");
    }

    public void updateUser(){
        System.out.println("updateUser");
    }

    public void updateUserPassword(){
        System.out.println("updateUserPassword");
    }

    public static void main(String[] args) {
        String action = "updateUser";

        try {
            Method m =UserServletTest.class.getDeclaredMethod(action);
            m.invoke(new UserServletTest());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

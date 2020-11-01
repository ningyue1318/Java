package com.syn.springApplication.chapter7;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;

public class ForumService {

    @NeedTest(value = true)
    public void deleteForum(int forumId){
        System.out.println("删除论坛模块:"+forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId){
        System.out.println("删除论坛主题:"+postId);
    }

    public static void main(String[] args) {
        Class clazz = ForumService.class;

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for(Method method:methods){
            NeedTest nt = method.getAnnotation(NeedTest.class);
            System.out.println(method.getName());
            if(nt!=null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello'+'World'");
        String message = (String)exp.getValue();
        System.out.println(message);
    }
}

package com.itcast.controller;

import com.itcast.domain.SysLog;
import com.itcast.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;
    private Class clazz;
    private Method method;

    @Before("execution(* com.itcast.controller..*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        System.out.println("执行前置通知");
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object [] args = jp.getArgs();
        if(args.length==0||args==null){
            method = clazz.getMethod(methodName);
        }else {
            Class[] classArgs = new Class[args.length];
            for(int i=0;i<classArgs.length;i++){
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }

     }

    @After("execution(* com.itcast.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        System.out.println("执行后置通知");
        Long time = new Date().getTime()- visitTime.getTime();

        if(clazz!=null&&method!=null&&clazz!= LogAop.class){
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String url = "";
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                url = classAnnotation.value()[0]+methodAnnotation.value()[0];
                SysLog sysLog = new SysLog();
                sysLog.setExecutionTime(time);
                sysLog.setUrl(url);
                String ip = request.getRemoteAddr();
                sysLog.setIp(ip);
                SecurityContext context = SecurityContextHolder.getContext();
                String username = ((User)(context.getAuthentication().getPrincipal())).getUsername();
                sysLog.setUsername(username);
                sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                sysLog.setVisitTime(visitTime);
                sysLogService.save(sysLog);
            }
        }
    }
}

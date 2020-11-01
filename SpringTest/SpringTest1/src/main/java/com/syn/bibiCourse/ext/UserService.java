package com.syn.bibiCourse.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/*
   原理:使用EventListenerMethodProcessor处理器来解析@EventListener注解
   SmartInitializingSingleton
   1 refresh()方法
   2 finishBeanFactoryInitialization方法，初始化剩下的单实例Bean
        2.1 创建所有的单实例Bean，getBean()
        2.2 获取所有创建好的单实例Bean,判断是否是SmartInitializingSingleton方法
            如果是就调用afterSingletonsInstantiated()
 */
@Service
public class UserService {

    @EventListener(classes = ApplicationEvent.class)
    public void listen(ApplicationEvent event){
        System.out.println("UserService监听到的事件"+event);
    }
}

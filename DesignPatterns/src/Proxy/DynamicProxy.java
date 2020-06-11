package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    代理模式的应用场景：
        1.业务系统的非功能性需求开发，如：监控，统计，鉴权，限流，事物等，这些功能需要在不破坏原有功能的基础上，添加新的功能。
        2.在RPC，缓存中应用。

     实现方法：
        1.通过接口实现，业务类和代理类实现同一个接口，在代理类的实现中，调用业务类的代码。
        2.通过继承的方式实现，没有办法实现定义接口的时候，通过继承的方式来实现代理
        3.当需要代理的类过多的时候，采用动态代理的方式来减少系统的代码量。


     动态代理参考链接：https://www.liaoxuefeng.com/wiki/1252599548343744/1264804593397984
 */
public class DynamicProxy {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if(method.getName().equals("morning")){
                    System.out.println("Good morning,"+args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler
        );

        hello.morning("bob");

    }
}

interface Hello{
    void morning(String name);
}

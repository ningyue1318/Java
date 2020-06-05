package RPC.package01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object target;

    JDKProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return ((RealHello)target).invoke();
    }


    public static void main(String[] args) {
        JDKProxy proxy = new JDKProxy(new RealHello());

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.setProperty("Others.RPC.package01.saveGeneratedFiles","true");
        Hello test = (Hello) Proxy.newProxyInstance(classLoader,new Class[]{Hello.class},proxy);
        System.out.println(test.say());


    }
}

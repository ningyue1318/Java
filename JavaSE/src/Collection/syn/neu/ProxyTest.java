package Collection.syn.neu;

import static Collection.syn.neu.ProxyFactory.getProxyInstance;

public class ProxyTest {
    /*
    如何根据加载到内存中的被代理类，动态的创建一个代理类及对象
    当通过代理类对象的对象调用方法时，怎么调用被代理被的方法
     */

    public static void main(String[] args) {
        Human proxyInstance =(Human)ProxyFactory.getProxyInstance(new SuperMan());
        proxyInstance.getBelief();
        proxyInstance.eat("四川麻辣烫");
    }
}

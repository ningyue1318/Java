package Factory;

public class book {
}
/*
   应用场景：根据 .json .xml .yaml后缀选择不同的解析器。生产不同对象。

   实现方式1.0：
        直接if-else判断，生成不同的解析器。过多的if-else判断，为了代码可读性，将代码封装到一个类中形成2.0方式。

   实现方式2.0：
         逻辑过于复杂抽象到一个类中，形成简单工厂模式。

         简单工厂：
             定义一个接口，不同的解析器继承这个接口，在Factory里面创建对象。
             把所有的判断逻辑都放在了Factory里面，

         每次新增后缀名，都需要修改if-else语句，为了不修改if-else语句，不违反开放-关闭规则，引入工厂方法。

   实现方式3.0
         工厂方法：
             把所有的if-eLse，利用多态方式解耦。
             首先创建工厂接口，然后创建工厂实现类，引用产品接口
             创建产品接口，创建产品实现类。

         每次新增需求，都要多写工厂类，避免过的的编写工厂类，引入抽象工厂方法。

   实现方式4.0
        抽象工厂方法：
            一个工厂生产多个产品。

 */

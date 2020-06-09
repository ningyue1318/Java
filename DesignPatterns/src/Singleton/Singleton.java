package Singleton;

/*
  1.为什么需要使用单例
    一个类只允许创建一个类或者对象，这个类就叫单例类。
    -在处理资源访问冲突的时候使用单例类，如一个向文件写入数据的类。
        eg：
        public class Logger{
            private FileWriter writer;
            private static final Logger instance = new Logger();

            private Logger(){
                File file = new File("/Users/wangzheng/log.txt");
                writer = new FileWriter(file,true);
            }

            public static Logger getInstance(){
                return instance;
            }

            public void log(String message){
                writer.write(message);
            }
        }

   -表示全局唯一类，例如配置信息类。
        eg:
        public class IdGenerator{
            private AtomicLong id = new AtomicLong(0);
            private static final IdGenerator instance = new IdGenerator();
            private IdGenerator(){}

            public static IdGenerator getInstance(){
                return instance;
            }

            public long getId(){
                return id.incrementAndGet();
            }
        }

  2.单例存在哪些问题
    -对封装，继承，抽象，多态的特性支持不是很友好。
    -隐藏类之间的依赖关系
    -对代码扩展性不友好
    -测试性不友好
    -不支持有参数的构造

  3.单例与静态类有那些区别
  4.有何可替代的方案
 */

import Basic.IdGenerator;

import java.util.concurrent.atomic.AtomicLong;

/*
    饿汉式实现
    优点：线程安全
    缺点：不能延迟加载，如果实例占用资源过多，会导致加载时间比较长。
 */
public class Singleton {
    private AtomicLong id = new AtomicLong(0);
    private static final Singleton instance = new Singleton();

    private  Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}

/*
    懒汉式加载
    优点：延迟加载
    缺点：对getInstance方法加类锁，并发度低。
 */
class Singleton1{
    private AtomicLong id = new AtomicLong(0);
    private static Singleton1 instance;

    private Singleton1(){}

    public static synchronized Singleton1 getInstance(){
        if(instance==null){
            instance = new Singleton1();
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}

/*
    双重检测
    优点：支持延迟加载，支持高并发
    缺点：
 */
class Singleton2{
    private AtomicLong id = new AtomicLong(0);
    private static Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(instance==null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}

/*
    静态内部类
 */

class Singleton3{
    private AtomicLong id = new AtomicLong(0);

    private Singleton3(){}

    private static class SingletonHolder{
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}

/*
    枚举实现
 */

enum Singleton4{
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId(){
        return id.incrementAndGet();
    }
}


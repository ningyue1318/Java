public class Summary01 {
}
/*
    装饰器模式和代理模式的区别：
        代理模式：增加和原始类无关的功能
        装饰器模式：增加和装饰器相关的功能

        适配器模式：是一种事后补救的策略
        桥接模式：将接口部分和实现部分分离


    public interface IA{
        void f();
    }

    public class A implements IA{
        public void f()
    }

    public class AProxy implements IA{
        private IA a;

        public AProxy(IA a){
            this.a = a;
        }

        public void f(){
            //添加新的代理逻辑
            a.f();
            //添加新的代理逻辑
        }
    }


    public interface IA{
        void f();
    }

    public class A implements IA{
        public void f()
    }

    public class ADecorator implements IA{
        private IA a;

        public ADecorator(IA a){
            this.a = a;
        }

        public void f(){
            //功能增强代码
            a.f();
            //功能增加代码
        }
    }



    适配器的应用场景：
        1.封装有缺陷的借口设计
        2.统计多个类的接口设计
        3.替换外部依赖系统
        4.兼容老版本接口
        5.适配不同格式的数据

    适配器的实现方式：
        类适配器：基于继承
        public interface ITarget{
            void f1();
            void f2();
            void fc();
        }

        public class Adaptee{
            public void fa();
            public void fb();
            public void fc()
        }

        public class Adapter extends Adaptee implements ITarget{
            public void f1(){
                super.fa();
            }

            public void f2(){
                super.fb();
            }

            pubic void f3(){
                super.fc();
            }
        }


        对象适配器：基于组合
        public class Adptor implements ITarget{
            private Adaptee adatee;

            public Adaptor(Adaptee adaptee){
                this.adaptee = adaptee;
            }

            public void f1(){
                adaptee.fa();
            }

            public void f2(){
                adaptee.fb();
            }

             public void f3(){
                adaptee.fc();
            }
        }
 */

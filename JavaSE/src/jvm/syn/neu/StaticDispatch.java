package jvm.syn.neu;

public class StaticDispatch {
    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("Hello,guy!");
        }
    }

    static class Woman extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello,lady!");
        }
    }


    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}

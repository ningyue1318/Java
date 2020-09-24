package jvm.syn.neu;

interface Callable{
    void call(String s);
}

class Describe{
    void show(String msg){
        System.out.println(msg);
    }
}


public class LamdaTest3 {
    static void hello(String name){
        System.out.println("Hello, "+name);
    }

    static class Description{
        String about;
        Description(String desc){about = desc;}
        void help(String msg){
            System.out.println(about+" "+msg);
        }
    }

    static class Helper{
        static void assit(String msg){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();

        Callable c = d::show;
        c.call("call()");

        new Thread(()-> System.out.println("lambda")).start();
    }
}

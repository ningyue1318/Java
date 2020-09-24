package Consurrent.syn.neu;

import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        ThreadUnsafe test = new ThreadUnsafe();
        for(int i=0;i<2;i++){
            new Thread(()->{
               test.method1(1000);
            }).start();
        }
    }
}

class ThreadUnsafe{
    ArrayList<String> list = new ArrayList<>();

    public void method1(int loopNumber){
        for(int i=0;i<loopNumber;i++){
            method2();
            method3();
        }
    }

    private void method2(){list.add("1");}

    private void method3(){list.remove(0);}
}

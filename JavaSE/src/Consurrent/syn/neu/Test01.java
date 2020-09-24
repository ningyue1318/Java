package Consurrent.syn.neu;


import java.util.concurrent.atomic.AtomicInteger;

public class Test01 {
    public static int counter = 0;
    public static final Object room = new Object();
    public static void main(String[] args) throws InterruptedException {
       Thread a = new Thread(()->{
           for(int i=0;i<5000;i++){
               synchronized (room) {
                   counter++;
               }
           }
       },"t1");

       Thread b = new Thread(()->{
          for(int i=0;i<5000;i++){
              synchronized (room) {
                  counter--;
              }
          }
       },"t2");

        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(counter);

    }
}

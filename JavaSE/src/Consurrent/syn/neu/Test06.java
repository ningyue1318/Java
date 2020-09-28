package Consurrent.syn.neu;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class Test06 {
    public static void main(String[] args) {
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();

        new Thread(()->{
            try{
                System.out.println("putting 1");
                integers.put(1);
                System.out.println("1 putted");

                System.out.println("putting 2");
                integers.put(2);
                System.out.println("2 putted");

            }catch (InterruptedException e){

            }
        },"t1").start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(()->{
            try{
                System.out.println("taking 1");
                integers.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            try{
                System.out.println("taking 2");
                integers.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"t3").start();


    }
}

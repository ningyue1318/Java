package Consurrent.syn.neu;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class Test11 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        CyclicBarrier barrier = new CyclicBarrier(2,()->{
            System.out.println("task1 task2 finish...");
        });

        for(int i=0;i<3;i++){
            service.submit(()->{
                System.out.println("task1 begin....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            service.submit(()->{
                System.out.println("task2 begin....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
    }
}

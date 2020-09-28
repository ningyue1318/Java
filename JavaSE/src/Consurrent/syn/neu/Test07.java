package Consurrent.syn.neu;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test07 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.println("开始执行时间"+new Date());
        executor.schedule(()->{
            System.out.println("任务1，执行时间"+new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000, TimeUnit.MILLISECONDS);

        executor.schedule(()->{
            System.out.println("任务2，执行时间"+new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000, TimeUnit.MILLISECONDS);

        executor.shutdown();

    }
}

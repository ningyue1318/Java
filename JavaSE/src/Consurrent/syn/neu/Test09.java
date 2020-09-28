package Consurrent.syn.neu;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

public class Test09 {
    private int data;

    private final StampedLock lock = new StampedLock();

    public Test09(int data){
        this.data = data;
    }

    public int read(int readTime){
        long stamp = lock.tryOptimisticRead();
        System.out.println("optimistic read locking"+stamp);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(lock.validate(stamp)){
            System.out.println("read finish"+stamp);
            return data;
        }

        System.out.println("updating to read lock"+stamp);
        try{
            stamp = lock.readLock();
            System.out.println("read lock"+stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("read finish"+stamp);
            return data;
        }finally {
            System.out.println("read unlock"+stamp);
            lock.unlock(stamp);
        }
    }

    public void write(int newData){
        long stamp = lock.writeLock();
        System.out.println("write lock"+stamp);
        try {
            Thread.sleep(2000);
            this.data = newData;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("write unlock"+stamp);
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        // 1. 创建 semaphore 对象
        Semaphore semaphore = new Semaphore(3);
        // 2. 10个线程同时运行
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 3. 获取许可
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(new Date()+" running...");
                    Thread.sleep(1000);
                    System.out.println(new Date()+" end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 4. 释放许可
                    semaphore.release();
                }
            }).start();
        }
    }
}

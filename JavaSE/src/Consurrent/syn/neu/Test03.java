package Consurrent.syn.neu;

public class Test03 {
    public final static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("t1进入线程");
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1:我运气好，我先走了!");

        },"t1").start();

        new Thread(()->{
            System.out.println("t2进入线程");
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2:我运气好，我先走了!");

        },"t2").start();



        Thread.sleep(2000);
        synchronized (lock){
            System.out.println("看看谁运气好");
            lock.notify();
        }
    }
}

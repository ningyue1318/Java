package Consurrent.syn.neu;


public class Test04 {

    private static int num = 0;
    private static Object lock = new Object();


    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock) {

                for (int i=0;i<5;i++) {
                    while (num != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print("a");
                    num = 1;
                    lock.notifyAll();
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock) {

                for(int i=0;i<5;i++) {
                    while (num != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print("b");
                    num = 2;
                    lock.notifyAll();
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock) {
                for(int i=0;i<5;i++) {
                    while (num != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print("c");
                    num = 0;
                    lock.notifyAll();
                }
            }
        }).start();
    }
}

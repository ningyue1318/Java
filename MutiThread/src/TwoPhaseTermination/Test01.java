package TwoPhaseTermination;

import javax.swing.*;

class CountUpThread extends Thread{
    private long counter = 0;

    private volatile boolean shutdownRequested = false;

    public void shutdownRequested(){
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested(){
        return shutdownRequested;
    }

    public void run(){
        try{
            while(!isShutdownRequested()){
                doWork();
            }
        }catch (InterruptedException e){

        }finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork:counter = "+counter);
        Thread.sleep(500);
    }

    private void doShutdown(){
        System.out.println("doShutdown:counter = "+counter);
    }
}
public class Test01 {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        try{
            CountUpThread t = new CountUpThread();
            t.start();

            Thread.sleep(10000);
            System.out.println("main:shutdownRequest");
            t.shutdownRequested();
            System.out.println("main:join");
            t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main:END");
    }
}

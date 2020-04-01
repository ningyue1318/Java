package Future;

import javax.swing.*;

interface Data {
    public abstract String getContent();
}

class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println(" making RealData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        System.out.println(" making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}

class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData){
        if(ready){
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }


    @Override
    public synchronized String getContent() {
        while(!ready){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        return realData.getContent();
    }
}

class Host {
    public Data request(final int count, final char c) {
        System.out.println("request("+count+", "+c+") BEGIN");

        final FutureData future = new FutureData();

        new Thread(){
            public void run(){
                RealData realData = new RealData(count,c);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }
}

public class Test01 {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        Data data1 = host.request(10,'A');
        Data data2 = host.request(20,'B');
        Data data3 = host.request(30,'C');
        System.out.println("main otherJob BEGIN");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        System.out.println("main otherJob END");

        System.out.println("data1 ="+data1.getContent());
        System.out.println("data2 ="+data2.getContent());
        System.out.println("data3 ="+data3.getContent());
        System.out.println("main END");
    }
}

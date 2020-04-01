package WorkerThread;

import javax.print.DocFlavor;
import java.util.Random;

class Request{
    private final String name;
    private final int number;
    private static  final Random random = new Random();

    public Request(String name,int number){
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+" executes "+this);
        try{
            Thread.sleep(random.nextInt(1000));
        }catch (InterruptedException e){

        }
    }

    public String toString(){
        return "[ Request from "+name +"No."+number+" ]";
    }
}

class Channel{
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private int tail;
    private int head;
    private int count;

    private final WorkerThread[] threadPool;

    public Channel(int threads){
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        threadPool = new WorkerThread[threads];
        for(int i=0;i<threadPool.length;i++){
            threadPool[i] = new WorkerThread("Worker-"+i,this);
        }
    }

    public void startWorkers(){
        for(int i=0;i<threadPool.length;i++){
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Request request){
        while(count>=requestQueue.length){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        requestQueue[tail] =request;
        tail = (tail+1)%requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest(){
        while(count<=0){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        Request request = requestQueue[head];
        head = (head+1)%requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
class ClientThread extends Thread{
    private final Channel channel;
    private static final Random random = new Random();

    public ClientThread(String name, Channel channel){
        super(name);
        this.channel = channel;
    }

    @Override
    public void run(){
        try{
            for(int i=0;true;i++){
                Request request = new Request(getName(),i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){

        }
    }
}

class WorkerThread extends Thread{
    private final Channel channel;
    public WorkerThread(String name, Channel channel){
        super(name);
        this.channel = channel;
    }

    @Override
    public void run(){
        while(true){
            Request request = channel.takeRequest();
            request.execute();
        }
    }

}
public class Test01 {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();

    }
}

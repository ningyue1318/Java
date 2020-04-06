package ThreadSpecificStorage;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class TSLog{
    private PrintWriter writer = null;

    public TSLog(String filename){
        try{
            writer = new PrintWriter(new FileWriter(filename));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void println(String s){
        writer.println(s);
    }

    public void close(){
        writer.println("====End of log====");
        writer.close();
    }
}

class Log1{
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    public static void println(String s){
        getTSLog().println(s);
    }

    public static void close(){
        getTSLog().close();
    }

    private static TSLog getTSLog(){
        TSLog tsLog = tsLogCollection.get();

        if(tsLog == null){
            tsLog = new TSLog(Thread.currentThread().getName()+"-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }

}

class ClientThread extends Thread{
    public ClientThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println(getName()+" BEGIN");
        for(int i=0;i<10;i++){
            Log1.println("i ="+i);
        }
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){

        }
        Log1.close();
        System.out.println(getName()+" END");
    }
}

public class Test02 {
    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
        String s = "32";
    }
}

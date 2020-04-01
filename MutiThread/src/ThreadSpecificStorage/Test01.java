package ThreadSpecificStorage;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Log{
    private static PrintWriter writer = null;

    static {
        try{
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(String s){
        writer.println(s);
    }

    public static void close(){
        writer.println("====End of log====");
        writer.close();
    }
}

public class Test01 {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        for(int i=0;i<10;i++){
            Log.println("main:i="+i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
        Log.close();
        System.out.println("END");
    }
}

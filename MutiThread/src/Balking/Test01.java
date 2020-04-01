package Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

class Data{
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename,String content){
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void changed(String newContent){
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if(!changed){
            System.out.println(Thread.currentThread().getName()+" calls balk");
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException{
        System.out.println(Thread.currentThread().getName()+" calls doSave,content= "+content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}

class SaverThread extends Thread{
    private final Data data;

    public SaverThread(String name,Data data){
        super(name);
        this.data = data;
    }

    @Override
    public void run(){
        while (true){
            try {
                data.save();
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            };
        }
    }
}

class ChangerThread extends Thread{
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name,Data data){
        super(name);
        this.data = data;
    }

    public void run(){
        try {
            for (int i = 0; true; i++) {
                data.changed("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        Data data = new Data("data.txt","(empty)");
        new ChangerThread("ChangerThread",data).start();
        new SaverThread("SaverThread",data).start();
    }
}

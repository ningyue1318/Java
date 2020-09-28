package Consurrent.syn.neu;

import java.sql.Time;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test08 {
    private Object data;

    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read(){
        System.out.println(new Date()+"  获取读锁");
        r.lock();
        try{
            System.out.println(new Date()+"  读取");
            Thread.sleep(1000);
            return data;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(new Date()+"  释放读锁");
            r.unlock();
        }
        return null;
    }

    public void write(){
        System.out.println(new Date()+"  获取写锁");
        w.lock();
        try {
            System.out.println(new Date()+"  写入");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(new Date()+"  释放写锁");
            w.unlock();
        }
    }

    public static void main(String[] args) {
        Test08 a = new Test08();
        new Thread(()->{
            a.read();
        }).start();

        new Thread(()->{
            a.write();
        }).start();
    }

}

package Consurrent.syn.neu;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.Lock;

public class Test05 {
    static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Student stu = new Student();
        AtomicReferenceFieldUpdater update = AtomicReferenceFieldUpdater
                .newUpdater(Student.class,String.class,"name");
        System.out.println(update.compareAndSet(stu,null,"张三"));
        System.out.println(stu);
    }
}

class Student{
    public volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

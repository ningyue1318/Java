package Consurrent.syn.neu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestPool {
}

class ThreadPool{
    //任务队列
    private BlockingQueue<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers = new HashSet();

    //核心线程数
    private int coreSize;

    //获取任务超时时间
    private long timeOut;

    private  TimeUnit timeUnit;

    //执行任务
    public void execute(Runnable task){
        //任务没有超过coreSize时，直接交给worker对象执行
        //超过coreSize之后，加入任务队列等待
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else{
                taskQueue.put(task);
            }
        }
    }


    public ThreadPool(int coreSize, long timeOut, TimeUnit timeUnit, int queueCapacity) {
        this.coreSize = coreSize;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            while(task!=null||(task = taskQueue.take())!=null){
                try{
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task = null;
                }
            }
        }
    }
}

class BlockingQueue<T>{
    //任务队列
    private Deque<T> deque = new ArrayDeque<>();

    //锁
    private ReentrantLock lock = new ReentrantLock();

    //生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    //消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    //容量
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    //阻塞获取
    public T take(){
        lock.lock();
        try{
            while(deque.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //带超时的阻塞获取
    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try{
            //将时间统一转化为纳秒
            long naos = unit.toNanos(timeout);
            while(deque.isEmpty()){
                try {
                    if(naos<=0){
                        return null;
                    }
                    naos = emptyWaitSet.awaitNanos(naos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //阻塞添加
    public void put(T element){
        lock.lock();
        try{
            while(deque.size()==capacity){
                fullWaitSet.await();
            }

            deque.addLast(element);
            emptyWaitSet.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //获取大小
    public int size(){
        lock.lock();
        try{
            return deque.size();
        }finally {
            lock.unlock();
        }
    }

}
package TwoPhaseTermination;

import java.util.Random;
import java.util.concurrent.*;

class MyTask implements Runnable{
    private static final int PHASE = 5;
    private final CyclicBarrier phaseBarrier;
    private final CountDownLatch doneLatch;
    private final int context;
    private static final Random random = new Random(314159);

    public MyTask(CyclicBarrier phaseBarrier, CountDownLatch doneLatch, int context){
        this.phaseBarrier = phaseBarrier;
        this.doneLatch = doneLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try{
            for(int phase =0;phase<PHASE;phase++){
                doPhase(phase);
                phaseBarrier.await();
            }

        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }finally {
            doneLatch.countDown();
        }
    }

    protected void doPhase(int phase){
        String name = Thread.currentThread().getName();
        System.out.println(name+":MyTask:BEGIN:context="+context+", phase = "+phase);
        try{
            Thread.sleep(random.nextInt(3000));
        }catch (InterruptedException e){

        }
    }
}
public class Test02 {
    private static final int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("BEGIN");

        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action!");
            }
        };

        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS,barrierAction);
        CountDownLatch downLatch = new CountDownLatch(THREADS);

        try{
            for(int t=0;t<THREADS;t++){
                service.execute(new MyTask(phaseBarrier,downLatch,t));
            }
            System.out.println("AWAIT");
            downLatch.await();
        }catch (InterruptedException e){

        }finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}

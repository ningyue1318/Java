public class Test01 {
    private  long count = 0;

    public synchronized void add10K(){
        int idx = 0;
        while(idx++<10000){
            count+=1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Test01 test = new Test01();

        Thread th1 = new Thread(()->{
            test.add10K();
        });

        Thread th2 = new Thread(()->{
            test.add10K();
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(test.count);
    }
}

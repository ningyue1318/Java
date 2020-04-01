package TwoPhaseTermination;

public class Test03 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                while(true){
                    try{
                        if(Thread.currentThread().interrupted()){
                            throw  new InterruptedException();
                        }
                        System.out.println(".");
                    }catch (InterruptedException e) {
                        System.out.println("*");
                        break;
                    }
                }
            }
        };

        t.start();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }
}

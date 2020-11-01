package com.syn.springApplication.chapter12;

public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    private static class TestClient extends Thread{
        private SequenceNumber sn;
        public TestClient(SequenceNumber sn,String name){
            super(name);
            this.sn = sn;
        }

        @Override
        public void run(){
            for(int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName()+sn.getNextNum());
            }
        }
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn,"T1线程");
        TestClient t2 = new TestClient(sn,"T2线程");
        TestClient t3 = new TestClient(sn,"T3线程");
        t1.start();
        t2.start();
        t3.start();
    }
}

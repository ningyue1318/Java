package jvm.syn.neu;

public class AssertTest {
    public static void main(String[] args) {
        AssertTest a = new AssertTest();
        a.localVarGC3();
    }

    public void localVarGC1(){
        byte[] buffer = new byte[10*1024*1024];
        System.gc();
    }

    public void localVarGC2(){
        byte[] buffer = new byte[10*1024*1024];
        buffer = null;
        System.gc();
    }

    public void localVarGC3(){
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGC4(){
        byte[] buffer = new byte[10*1024*1024];
        int value =10;
        System.gc();
    }

    public void localVarGC5(){
        localVarGC1();
        System.gc();
    }
}

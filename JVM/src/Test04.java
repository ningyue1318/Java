public class Test04 {
    public Object instance = null;

    private static final int _1MB =1024*1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        Test04 objA = new Test04();
        Test04 objB = new Test04();

        objA.instance = objB;
        objB.instance = objA;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}

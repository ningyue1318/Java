package jvm.syn.neu;

public class User {
    private String name;
    private String age;
    private String gender;
    private String phone;

    private static void alloc(){
        User user = new User();
    }
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为："+(end-start)+"ms");
        Thread.sleep(1000000);
    }

}

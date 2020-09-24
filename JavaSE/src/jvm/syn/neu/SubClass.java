package jvm.syn.neu;

public class SubClass extends SuperClass{
    static {
        System.out.println("SubCLass init");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

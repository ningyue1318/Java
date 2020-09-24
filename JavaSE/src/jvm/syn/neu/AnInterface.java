package jvm.syn.neu;

public interface AnInterface {
    void firstMethod();
    void secondMethod();

    default void newMethod(){
        System.out.println("newMethod");
    }
}

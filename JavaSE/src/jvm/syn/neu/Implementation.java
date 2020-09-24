package jvm.syn.neu;

public class Implementation implements AnInterface{
    @Override
    public void firstMethod() {
        System.out.println("firstMethod");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    public static void main(String[] args) {
        AnInterface i = new Implementation();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}

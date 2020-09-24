package jvm.syn.neu;

public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface{

        @Override
        public void howdy() {
            System.out.println("howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }

}

package jvm.syn.neu;

public class LamdaTest1 {


    public static void main(String[] args) {
        LamdaTest1 test = new LamdaTest1();

        MathOperation add =(int a,int b)->a+b;

        System.out.println(test.operate(1,2,add));
    }
    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}

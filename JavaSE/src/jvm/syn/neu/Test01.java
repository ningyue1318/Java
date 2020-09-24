package jvm.syn.neu;

import java.util.Random;

public class Test01 {
    public static boolean test1(int val){
        System.out.println("test1("+val+")");
        System.out.println("result:"+(val<1));
        return val<1;
    }

    public static boolean test2(int val){
        System.out.println("test2("+val+")");
        System.out.println("result:"+(val<2));
        return val<1;
    }

    public static boolean test3(int val){
        System.out.println("test3("+val+")");
        System.out.println("result:"+(val<1));
        return val<1;
    }

    public static void main(String[] args) {
       /*
        boolean b = test1(0)&&test2(2)&&test3(2);
        System.out.println("expression is "+b);
        double d = 31_45_45_667*10;
        System.out.println(d);
        */
       Random rand = new Random(47);
       float [] f = new float[10];
       for(int i = 0; i < 10; i++)
            f[i] = rand.nextFloat();
       for(float x:f)
           System.out.println(x);

       for (char c : "An African Swallow".toCharArray())
           System.out.println(c);

       Integer a = 10;
       System.out.println(Integer.valueOf(2));

       String s1 = "java";
       String s2 = "java";
       String s3 = new String("java");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
    }




}

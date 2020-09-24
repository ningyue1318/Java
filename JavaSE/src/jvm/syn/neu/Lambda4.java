package jvm.syn.neu;

import java.util.function.IntSupplier;

public class Lambda4 {
    int i;

    IntSupplier makeFun(int x){
        return ()->x + i++;
    }

    public static void main(String[] args) {
        Lambda4 c = new Lambda4();
        IntSupplier f1 = c.makeFun(0);
        IntSupplier f2 = c.makeFun(0);
        IntSupplier f3 = c.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }
}

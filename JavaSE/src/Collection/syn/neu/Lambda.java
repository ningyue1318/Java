package Collection.syn.neu;

import jvm.syn.neu.Super;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {
        Runnable r1 = ()-> System.out.println("输出"); ;
        r1.run();

        Consumer<String> con =(String s) -> {
            System.out.println(s);
        };

        con.accept("你好");

        Consumer<String> con2 =(s) -> {
            System.out.println(s);
        };

        con2.accept("你好");

        Comparator<Integer> com2 = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12,2));

        Comparator<Integer> com3 = (o1,o2)->o1.compareTo(o2);

        Consumer<String> con5 = System.out::println;
        con5.accept("测试方法引用");

        Comparator<Integer> com5 = Integer::compare;

        System.out.println(com5.compare(2,3));

        Comparator<String> com6 = String::compareTo;
        System.out.println(com6.compare("123","345"));

    }
}

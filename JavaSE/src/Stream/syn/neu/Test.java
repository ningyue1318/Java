package Stream.syn.neu;

import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {

        Supplier<String> s = ()-> {
              return "你好";
        };
        test((Supplier<String>)()-> {
            return "你好";
        });
    }


    public static void test(Supplier<String> s){
        System.out.println(s.get());
    }
}


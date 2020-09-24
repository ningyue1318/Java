package Collection.syn.neu;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("你好","Hello");
        map.put("hello","你好");
        System.out.println(map.get("你好"));
    }
}

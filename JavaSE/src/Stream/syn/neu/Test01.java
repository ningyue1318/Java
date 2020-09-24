package Stream.syn.neu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("asd");
        list.add("zxc");
        Stream<String> stream =list.stream();

        int [] arr = new int[]{1,2,3,4,5,6};
        Arrays.stream(arr);
    }

    @Test
    public void test01(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x>2).forEach(System.out::println);

        list.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.stream()
                .map(x->x+2)
                .filter(x->x>4)
                .forEach(System.out::println);
    }

    @Test
    public void test03(){
        List<Integer> list = new ArrayList<>();
        list.add(14343);
        list.add(23232);
        list.add(323);
        list.add(43);
        list.add(5);
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void test04(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer sum = list.stream()
                          .reduce(0,Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void test05(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Object o = list.stream()
                .collect(Collectors.counting());
        System.out.println(o);
    }
}

package Collection.syn.neu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        updateList(a);
        System.out.println(a);
    }

    private static void updateList(List list){
        list.remove(2);
    }

    @org.junit.Test
    public void TestJunit(){
        ArrayList a = new ArrayList();
        a.add(123);
        a.add(234);
        a.add(345);
        a.add(456);
        for (Object b :a){
            System.out.println(b);
        }
        LinkedList b = new LinkedList();
        Vector c = new Vector();
    }

    @org.junit.Test
    public void TestYiwei(){
        System.out.println(10>>1);
        System.out.println(15>>1);
        HashSet a = new HashSet();
        a.add(1);
        LinkedHashSet b = new LinkedHashSet();
        Object c =new Object();
        HashMap d = new HashMap();
        LinkedHashMap e = new LinkedHashMap();

    }

    @org.junit.Test
    public void test4() throws IOException {
        Properties pro = new Properties();
        FileInputStream fio = new FileInputStream("jdbc.properties");
        pro.load(fio);

        System.out.println(pro.getProperty("name"));

        ArrayList<String> a = new ArrayList ();
        a.add("123");
    }

    @org.junit.Test
    public void test5(){
        List<Object> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
       // a=b;

        List<?> c = new ArrayList<>();
        c=a;


    }

    @org.junit.Test
    public void test6(){
        List<? extends Person> a = new ArrayList<>();
        List<? super Person> b = new ArrayList<>();

        List<Student> c = null;
        List<Person> d = null;
        List<Object> e = null;


        b.add(new Student());
        b.add(new Person());

        Person f = a.get(0);
        Object g =b.get(0);

    }


}

package reflect.syn.neu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        Person p = new Person();
        //p.show();

        Class clazz = Person.class;

        Constructor cons =clazz.getConstructor(String.class,int.class);

        Person obj =(Person)cons.newInstance("Tom",12);

        System.out.println(obj.toString());
        Field age = clazz.getDeclaredField("age");
        age.set(obj,100);
        System.out.println(obj);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        Field name = clazz.getDeclaredField("username");
        name.setAccessible(true);
        name.set(p,"Lisa");
        System.out.println(p);

        //获取class对象的方式
        //调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;

        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();

        //方式三：调用Class的静态方法，
        Class clazz3 = Class.forName("reflect.syn.neu.Person");

        //方式四：使用类的加载器
        ClassLoader classLoader = Test01.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("reflect.syn.neu.Person");
    }
}

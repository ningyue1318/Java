package reflect.syn.neu;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Test02 {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        Class clazz = Student.class;

        //只能获取父类和自己的public属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        //获取自己的声明的所有属性，不包含父类中的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
        }

        //权限修饰符 数据类型 变量名
        for(Field f:declaredFields){
            //权限修饰符,用常量表示修饰符，
            System.out.print(Modifier.toString(f.getModifiers())+"\t");

            //数据类型
            System.out.print(f.getType()+"\t");

            //变量名
            System.out.print(f.getName()+"\t");

            System.out.println();
        }
    }

    @Test
    public void test2(){
        Class clazz = Student.class;

        //获取当前类和父类的public方法
        Method[] methods = clazz.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }

        //包含当前类声明的所有方法（不包含父类）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m:declaredMethods){
            System.out.println(m);
        }

    }

    @Test
    public void test3(){
        //获取方法声明的注解
        Class clazz = Student.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m:declaredMethods){
            //获取注解
            Annotation[] annos=m.getAnnotations();
            for (Annotation a:annos){
                System.out.print(a+"\t");
            }

            //权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");

            //返回值类型
            System.out.print(m.getReturnType().getName()+"\t");

            //方法名
            System.out.print(m.getName()+"\t");

            //形参列表
           Class[] parameterTypes = m.getParameterTypes();
           if(!(parameterTypes==null||parameterTypes.length==0)){
               for(Class p:parameterTypes){
                   System.out.print(p.getName()+"\t");
               }
           }

           //抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(!(exceptionTypes==null||exceptionTypes.length==0)){
                for(Class p:exceptionTypes){
                    System.out.print(p.getName()+"\t");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void test4(){
        Class clazz = Student.class;

        //获取父类
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        //获取带有泛型的父类
        Type superclass1 = clazz.getGenericSuperclass();
        System.out.println(superclass1);

        //获取父类的泛型信息
        ParameterizedType paramType = (ParameterizedType) superclass1;
        Type[] actualTypeArgument = paramType.getActualTypeArguments();
        System.out.println(actualTypeArgument[0]);
    }

    @Test
    public void test5(){
        Class clazz = Student.class;

        //获取当前类的接口
        Class[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.println(c);
        }

        //获取当前类所在的包
        System.out.println(clazz.getPackage());
    }

    @Test
    public void test6() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //调用运行时类中指定的结构：属性，方法，构造器

        Class clazz = Student.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性,要求属性值为public，通常不采用此方式
        Field id = clazz.getField("id");
        //设置当前属性的值，
        id.set(p,1001);

        //获取当前属性的值
        int pId = (int)id.get(p);
        System.out.println(pId);

        //获取指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"LiLi");
        System.out.println(name.get(p));

    }


    @Test
    public void test7() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class clazz = Student.class;
        Person p = (Person)clazz.newInstance();

        //获取指定的某个方法
        Method m = clazz.getDeclaredMethod("show",String.class);
        m.setAccessible(true);
        //接受返回值
        Object returnValue = m.invoke(p,"中国");
        System.out.println(returnValue);

        //调用静态方法
        Method m1 =clazz.getDeclaredMethod("showDesc");
        m1.invoke(Person.class);
    }
}

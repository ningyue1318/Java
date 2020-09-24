package jvm.syn.neu;

public class Sub extends Super {
    public int field = 1;

    @Override
    public int getField(){
        return field;
    }

    public int getSuperField(){
        return super.field;
    }

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader classLoader = Sub.class.getClassLoader();
        System.out.println(classLoader);
    }
}


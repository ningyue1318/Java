package reflect.syn.neu;

@MyAnnotation
public class Student extends Person<String> implements Comparable<String>{

    private String name;
    int age;
    public int id;

    public Student(){}

    @MyAnnotation(value = "abc")
    private Student(String name){
        this.name = name;
    }

    Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    public String display(String interests){
        System.out.println();
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}

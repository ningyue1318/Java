package jvm.syn.neu;


import java.lang.reflect.Field;

public class AnnotationTest {
    @SQLString(value=30,name="123")
    String firstName;


    String LastName;

    public static void main(String[] args) throws NoSuchFieldException {
        AnnotationTest a = new AnnotationTest();
      for(Field f :AnnotationTest.class.getDeclaredFields()){
          System.out.println(f);
      }

    }
}

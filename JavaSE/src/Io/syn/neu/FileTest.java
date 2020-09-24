package Io.syn.neu;

import org.junit.Test;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {
    }

    @Test
    public void Test1() {
        File file = new File("D:\\IDEA\\StudySpace\\JavaSE\\src\\Io\\syn\\neu\\Hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            int data;
            while((data=fr.read())!=-1){
                System.out.print((char)data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test02(){
        File file = new File("D:\\IDEA\\StudySpace\\JavaSE\\src\\Io\\syn\\neu\\Hello1.txt");

        try {
            FileWriter fw = new FileWriter(file);
            fw.write("I have a dream\n");
            fw.write("you need to have a dream!");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Test
    public void test03(){
        File file = new File("D:\\IDEA\\StudySpace\\JavaSE\\src\\Io\\syn\\neu\\Hello.txt");
        FileInputStream fio=null;
        try {
             fio = new FileInputStream(file);

            byte[] buffer = new byte[100];
            int len;
            while((len=fio.read(buffer))!=-1){
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fio.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void Test04(){
        File file = new File("D:\\IDEA\\StudySpace\\JavaSE\\src\\Io\\syn\\neu\\Hello.txt");
        FileInputStream fio= null;
        BufferedInputStream bis = null;

        try {
            fio = new FileInputStream(file);
            bis = new BufferedInputStream(fio);

            int len;
            byte []buffer = new byte[5];
            while((len = bis.read(buffer))!=-1){
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fio.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
    }
}

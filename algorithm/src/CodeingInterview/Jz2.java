package CodeingInterview;

/*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    Input:We Are Happy
    output:We%20Are%20Happy。
 */
public class Jz2 {
    public String replaceSpace(StringBuffer str) {
        if(str.length()==0||str==null){
            return "";
        }
        char []data = str.toString().toCharArray();
        int numOfSpace =0;
        for(int i=0;i<str.length();i++){
            if(data[i]==' '){
                numOfSpace++;
            }
        }
        char [] result=new char[str.length()+numOfSpace*2];
        int index=0;
       for(int i=0;i<str.length();i++){
           if(data[i]==' '){
               result[index++] ='%';
               result[index++]='2';
               result[index++] ='0';
           }else{
               result[index] = data[i];
               index++;
           }
       }

       return new String(result);
    }

    public static void main(String[] args) {
        StringBuffer s =new StringBuffer("hello world");
        Jz2 z = new Jz2();
        System.out.println(z.replaceSpace(s));
    }
}

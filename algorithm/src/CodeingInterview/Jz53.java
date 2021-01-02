package CodeingInterview;

/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Jz53 {
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0) return false;
        int i=0;
        if(str[0]=='+'||str[0]=='-') i++;
        boolean flag = false;
        for(;i<str.length;i++){
            if(str[i]=='.'&&!flag) continue;
            if(str[i]=='e'||str[i]=='E'){
                if(str[i+1]=='+'||str[i+1]=='-') i++;
                flag = true;
                continue;
            }
            if(str[i]<'0'||str[i]>'9') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Jz53 z = new Jz53();
        System.out.println(z.isNumeric("123.45e+6".toCharArray()));
    }
}

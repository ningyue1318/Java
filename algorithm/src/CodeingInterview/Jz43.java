package CodeingInterview;

/*
    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
    例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Jz43 {
    public String LeftRotateString(String str,int n) {
        char [] sourceStr = str.toCharArray();
        char [] resultStr = new char[str.length()];
        for(int i = n;i<str.length();i++){
            resultStr[i-n] = sourceStr[i];
        }
        for(int i = str.length()-n;i<str.length();i++){
            resultStr[i] = sourceStr[i-str.length()+n];
        }
        return new String(resultStr);
    }

    public static void main(String[] args) {
        Jz43 z = new Jz43();
        System.out.println(z.LeftRotateString("XYZdefabc",3));
    }
}

package CodeingInterview;

/*
    输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class Jz11 {
    public int NumberOf1(int n) {
        String octNum = Integer.toBinaryString(n);
        String [] chars = octNum.split("");
        int result = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i].equals("1")){
                result++;
            }
        }
        return result;
    }

    public int NumberOf12(int n) {
        int result =0;
        int flag = 1;
        while(flag!=0){
            if((flag&n)!=0) result++;
            flag<<=1;
        }
        return result;
    }

    public static void main(String[] args) {
        Jz11 z = new Jz11();
        System.out.println(z.NumberOf12(10));
    }
}

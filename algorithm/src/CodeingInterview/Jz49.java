package CodeingInterview;

/*
    将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Jz49 {
    public int StrToInt(String str) {
        if(str.length()==0||str==null) return 0;
        int returnNum=0;
        for(int i=str.length()-1;i>=0;i--){
            char temp = str.charAt(i);
            if(temp>='0'&&temp<='9') {
                 returnNum+=Math.pow(10,str.length()-1-i)*(temp-'0');
            }else {
                if(i!=0){
                    return 0;
                }
            }
        }
        return returnNum;
    }

    public static void main(String[] args) {
        Jz49 z = new Jz49();
        System.out.println(z.StrToInt("123"));
    }
}

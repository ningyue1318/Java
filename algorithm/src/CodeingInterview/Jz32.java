package CodeingInterview;

/*
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
    打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
    则打印出这三个数字能排成的最小数字为321323。
 */
public class Jz32 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return null;
        }
        String []number_str = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            number_str[i] = Integer.toString(numbers[i]);
        }

        for(int i=0;i<number_str.length;i++){
            String temp;
            for(int j=0;j<number_str.length-i-1;j++){
                if(compare(number_str[j],number_str[j+1])){
                    temp = number_str[j];
                    number_str[j] = number_str[j+1];
                    number_str[j+1] = temp;
                }
            }
        }
        String returnData = "";
        for(int i=0;i<number_str.length;i++){
            returnData+=number_str[i];
        }
        return returnData;
    }

    public boolean compare(String a,String b){
        return Long.parseLong(a+b)>Long.parseLong(b+a)?true:false;
    }

    public static void main(String[] args) {
        int [] numbers = {3,32,321};
        Jz32 z = new Jz32();
        System.out.println(z.PrintMinNumber(numbers));
    }
}

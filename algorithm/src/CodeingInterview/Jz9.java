package CodeingInterview;

/*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Jz9 {
    public int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        int result = 1;
        int data[] = new int[target+1];
        data[1]=1;
        for(int i=2;i<=target;i++){
            data[i] = result+1;
            result+=data[i];
        }
        return data[target];
    }

    public int JumpFloorII1(int target) {
        if(target==1){
            return 1;
        }
        int []data = new int[target+1];
        data[1]=1;
        for(int i=2;i<=target;i++){
            data[i]=2*data[i-1];
        }
        return data[target];
    }

    public static void main(String[] args) {
        Jz9 z = new Jz9();
        System.out.println(z.JumpFloorII1(4));
    }
}

package CodeingInterview;

/*
    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 */
public class Jz7 {

    /*
        递归方式,
        时间复杂度O（2^n）
     */
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /*
        时间复杂度，O(n)
     */
    public int Fibonacci1(int n) {
        int []data = new int[40];
        data[0] = 0;
        data[1] = 1;
        for(int i=2;i<=n;i++){
            data[i] = data[i-1]+data[i-2];
        }
        return data[n];
    }


    public static void main(String[] args) {
        Jz7 z = new Jz7();
        System.out.println(z.Fibonacci(4));
    }
}

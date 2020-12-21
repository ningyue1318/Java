package CodeingInterview;


import java.util.HashMap;

/*
    求出1~13的整数中1出现的次数,
    并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Jz31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0) return 0;
        if(n<=9) return 1;
        int returnNum = 0;
        int x;//标志着最低位；
        HashMap<Integer,Integer> map = new HashMap<>();
        int temp = n;
        int i = 0;
        while(temp!=0){
            map.put(i,temp%10);
            i++;
            temp=temp/10;
        }
        System.out.println(map);
        for(i=0;i<map.size();i++){
            int j =map.get(i);
            if(j==1){
                returnNum += i*Math.pow(10,(i-1));
            }else if(j>1){
                returnNum += j*i*Math.pow(10,(i-1)) + Math.pow(10,i);
            }
        }
        for(i=map.size()-1;i>0;i--){
            if(map.get(i)==1){
                returnNum += (n%Math.pow(10,i))+1;
            }
        }
        return returnNum;
    }

    public static void main(String[] args) {
        Jz31 z = new Jz31();
        System.out.println(z.NumberOf1Between1AndN_Solution(10000));
        System.out.println(Math.pow(10,2));
    }
}

package CodeingInterview;

import java.util.ArrayList;

/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，
使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Jz42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array==null||array.length==0) return null;

        int numA = 0;
        int numB = 0;
        int multi = Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            int sub = sum - array[i];
            if(array[i]*sub<multi) {
                for (int j = array.length - 1; j >= 0; j--) {
                    if (sub == array[j]) {
                            numA = array[i];
                            numB = sub;
                    }
                    if(sub>array[j]) break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(numA);
        result.add(numB);
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array==null||array.length==0) return null;

        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]>sum){
                j--;
            }else if(array[i]+array[j]<sum){
                i++;
            }else{
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}

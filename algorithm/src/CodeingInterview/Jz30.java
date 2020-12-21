package CodeingInterview;

import java.lang.management.MonitorInfo;

/*
    输入一个整型数组，数组里有正数也有负数。
    数组中的一个或连续多个整数组成一个子数组。
    求所有子数组的和的最大值。要求时间复杂度为 O(n).
 */
public class Jz30 {
//    暴力搜索
//    int  maxValue = Integer.MIN_VALUE;
//    public int FindGreatestSumOfSubArray(int[] array) {
//        boolean isAllNegative = true;
//        for(int i=0;i<array.length;i++){
//            if(array[i]>0){
//                isAllNegative = false;
//            }
//            if(array[i]>maxValue){
//                maxValue = array[i];
//            }
//        }
//
//        if(isAllNegative) return maxValue;
//
//        calculate(0,array,true,0);
//        return maxValue;
//    }
//
//    public void calculate(int i,int[] array,boolean flag,int max){
//        if(i==array.length){
//            if(max>maxValue) maxValue = max;
//            return;
//        }
//        if(flag) {
//            calculate(i+1, array, true, max + array[i]);
//            calculate(i+1, array,false, max);
//        }else{
//            calculate(i+1, array, true,  array[i]);
//            calculate(i+1, array,false, 0);
//        }
//    }


    /*
        动态规划来做
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxValue = Integer.MIN_VALUE;

        int [] result = new int[array.length+1];
        result[0] = 0;
        for(int i=1;i<=array.length;i++){
            result[i] = Integer.max(array[i-1],array[i-1]+result[i-1]);
            maxValue = Integer.max(result[i],maxValue);
        }
        return maxValue;
    }
    public static void main(String[] args) {
        Jz30 z = new Jz30();
        int []array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(z.FindGreatestSumOfSubArray(array));
    }
}

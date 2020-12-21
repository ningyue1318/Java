package CodeingInterview;

import java.util.*;

/*
    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 */
public class Jz29 {
    /*
        冒泡排序
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> returnData = new ArrayList<>();
        if(input.length==0||k>input.length||k<0) return returnData;
        for(int i=0;i<input.length;i++){
            boolean flag = false;
            for(int j=0;j<input.length-i-1;j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        for(int i=0;i<k;i++){
            returnData.add(input[i]);
        }
        return returnData;
    }

    /*
        插入排序
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> returnData = new ArrayList<>();
        if(input.length==0||k>input.length||k<0) return returnData;
        for(int i=1;i<input.length;i++){
            int temp = input[i];
            int j = i-1;
            for(;j>=0;j--){
                if(input[j]>temp){
                    input[j+1] = input[j];
                }else{
                    break;
                }
            }
            input[j+1] =temp;
        }
        for(int i=0;i<k;i++){
            returnData.add(input[i]);
        }
        return returnData;
    }

    /*
        选择排序
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> returnData = new ArrayList<>();
        if(input.length==0||k>input.length||k<0) return returnData;
        for(int i=0;i<input.length;i++){
            int index = i;
            for(int j=i+1;j<input.length;j++){
                if(input[j]<input[index]){
                    index = j;
                }
            }
            int temp = input[i];
            input[i] = input[index];
            input[index]= temp;

        }
        for(int i=0;i<k;i++){
            returnData.add(input[i]);
        }
        return returnData;
    }
    /*
      快速排序
   */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> returnData = new ArrayList<>();
        if(input.length==0||k>input.length||k<0) return returnData;

        int l = 0;
        int r = input.length-1;
        int p = partition(input,l,r);
        while(p!=k-1){
            if(p<k-1){
                l = p+1;
                p = partition(input,l,r);
            }else{
                r = p-1;
                p = partition(input,l,r);
            }
        }
        for(int i=0;i<k;i++) returnData.add(input[i]);
        return returnData;
    }

    public int partition(int [] input,int p,int r){
        int i = p;
        int pivot = input[r];
        for(int j=p;j<r;j++){
            if(input[j]<pivot){
                if(i==j){
                    i++;
                }else{
                    int temp = input[i];
                    input[i++] = input[j];
                    input[j] = temp;
                }
            }
        }
        int temp = input[i];
        input[i] = input[r];
        input[r] = temp;
        return i;
    }




    public static void main(String[] args) {
        Jz29 z = new Jz29();
        int [] input = {4,5,1,6,2,7,3,8};
        System.out.println(z.GetLeastNumbers_Solution3(input,1));
    }
}

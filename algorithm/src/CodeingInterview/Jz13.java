package CodeingInterview;

import java.util.Arrays;

/*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Jz13 {
    /*
        时间复杂度O(n^2)
        空间复杂度O(n)
     */
    public void reOrderArray(int [] array) {
        int [] odd = new int[array.length];
        int [] even = new int[array.length];
        int oddNum = 0;
        int evenNum = 0;

        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                even[evenNum] = array[i];
                evenNum++;
            }else{
                odd[oddNum] = array[i];
                oddNum++;
            }
        }

        for(int i=0;i<evenNum;i++){
                odd[i+oddNum] = even[i];
        }
        for(int i=0;i<array.length;i++){
            array[i]= odd[i];
        }
    }

    /*
        冒泡排序变种
     */
    public void reOrderArray2(int [] array) {
        for(int i = 0;i<array.length;i++){
            boolean isChange=false;
            for(int j=0 ;j<array.length-1;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isChange = true;
                }
            }
            if(!isChange) break;
        }
    }

    /*
        选择排序变种
     */
    public void reOrderArray3(int [] array) {
        if(array.length<=1){
            return;
        }
        for(int i = 0;i<array.length;i++){
            if(array[i]%2==0){
                int j = i+1;
                while(array[j]%2==0){
                    if(j==array.length-1){
                        return;
                    }
                    j++;
                }

                int tmep = array[j];
                while(j-i>0){
                    array[j] =array[j-1];
                    j--;
                }
                array[i] = tmep;
            }
        }
    }



    public static void main(String[] args) {
        Jz13 z = new Jz13();
        int [] array = {1,2,3,4,5,6,7};
        z.reOrderArray3(array);
        System.out.println(Arrays.toString(array));
    }
}

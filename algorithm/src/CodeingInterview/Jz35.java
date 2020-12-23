package CodeingInterview;

import Basis.Array.Array;

import java.util.Arrays;

/*
    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

    对于50\%50%的数据,size\leq 10^4size≤10^4

    对于75\%75%的数据,size\leq 10^5size≤10^5

    对于100\%100%的数据,size\leq 2*10^5size≤2∗10^5
 */
public class Jz35 {
    private int num = 0;
    public int InversePairs(int [] array) {
        if(array.length==0||array==null) return 0;
        mergeSortInternally(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        return num%1000000007;
    }

    public void mergeSortInternally(int [] data,int p,int r){
        if(p>=r) return;

        int mid = p+(r-p)/2;

        mergeSortInternally(data,p,mid);
        mergeSortInternally(data,mid+1,r);

        merge(data,p,mid,r);
    }

    public void merge(int [] data,int p,int mid,int r){
        int i = p;      //前半部分指针
        int j = mid+1;    //后半部分指针
        int k = 0;      //新数组的指针

        int [] tmp = new int [r-p+1];
        while(i<=mid&&j<=r){
            if(data[i]<=data[j]){
                tmp[k++] = data[i++];
            }else{
                tmp[k++] = data[j++];
                num+= mid-i+1;
            }
        }


        int start = i;
        int end = mid;
        if(j<=r){
            start = j;
            end = r;
        }

        while(start<=end){
            tmp[k++] = data[start++];
        }

        for(i=0;i<=r-p;i++){
            data[p+i]=tmp[i];
        }
    }

    public static void main(String[] args) {
        Jz35 z = new Jz35();
        System.out.println(z.InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}

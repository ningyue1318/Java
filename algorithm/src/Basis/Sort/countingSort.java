package Basis.Sort;

public class countingSort {
    public static void countingSort(int [] a,int n){
        if(n<=1) return;

        int max = a[0];
        for(int i = 1;i<n;i++){
            if(a[i]>max){
                max = a[i];
            }
        }

        //数据的范围为【0-max】
        int [] c = new int [max+1];

        for(int i=0;i<n;i++){
            c[a[i]]++;
        }

        for(int i=1;i<max+1;i++){
            c[i] = c[i]+c[i-1];
        }

        int[] r = new int[n];

        for(int i=n-1;i>=0;i--){
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }
    }
}

package Basis.Sort;

import java.util.Arrays;

public class Sorts {

    /*
     *  冒泡排序
     */
    public static void bubbleSort(int [] a, int n){
        if(n<1){
            System.out.println("数组长度应该大于等于1");
            return;
        }

        for(int i=0;i<n;i++){
            boolean flag = false;
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    /*
     * 插入排序
     */
    public static void insertSort(int [] a, int n){
        if(n<1){
            System.out.println("数组长度应该大于等于1");
        }

        for(int i=1;i<n;i++){
            int value = a[i];
            int j = i-1;
            for(;j>=0;j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    /*
     * 选择排序
     */
    public static void selectionSort(int [] a, int n){
        if(n<1){
            System.out.println("数组长度应该大于1");
        }

        for(int i=0;i<n;i++){
            int min = i;
            for(int j =i;j<n;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            int tmp = a [min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }

    /*
     * 快速排序
     */
    public static void quickSort(int [] a,int n){
        quickSortInternally(a,0,n-1);
    }

    private static void quickSortInternally(int [] a,int p,int r){
        if(p>r) return;

        int q = partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    private static int partition(int [] a,int p,int r){
       int i = p;
       int pivot = a[r];
       for(int j=p;j<r;j++){
           if(a[j]<pivot){
               if(i==j){
                   i++;
               }else{
                   int tmp = a[i];
                   a[i++] = a[j];
                   a[j] = tmp;
               }
           }
       }
       int tmp = a[i];
       a[i] = a[r];
       a[r] = tmp;
       return i;
    }

    /*
     *归并排序
     */
    public static void mergeSort(int [] a,int n){
        mergeSortInternally(a,0,n-1);
    }

    private static void mergeSortInternally(int [] a,int p,int r){
        if(p>=r) return ;

        int q = p+(r-p)/2;

        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        merge(a,p,q,r);
    }

    private static void merge(int [] a,int p,int q,int r){
        int i = p;
        int j = q+1;
        int k = 0;
        int [] tmp = new int[r-p+1];
        while(i<=q&&j<=r){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }

        while(start<=end){
            tmp[k++] = a[start++];
        }

        for(i =0;i<=r-p;i++){
            a[p+i]=tmp[i];
        }
    }


    public static void main(String[] args) {
        int [] array = new int[]{3,4,2,1,5,6,7,8};
        mergeSort(array,8);
        System.out.println(Arrays.toString(array));
    }
}

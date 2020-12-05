package Sort;

public class HeapSort {
    public static void sort(int [] arr){
        if(arr.length<=1){
            return;
        }

        buildHeap(arr);

        int k = arr.length-1;
        while(k>1){
            swap(arr,1,k);
            heapify(arr,--k,1);
        }
    }

    private static void buildHeap(int [] arr){
        for(int i=arr.length-1/2;i>=1;i--){
            heapify(arr,arr.length-1,i);
        }
    }

    private static void heapify(int [] arr,int n,int i){
        while(true) {
            int maxPos = i;
            if (i * 2  <= n && arr[i] < arr[i * 2 ]) {
                maxPos = i * 2 ;
            }
            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int [] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int []data =  new int[]{0,7,5,19,8,4,1,20,13,16};
        sort(data);
        for(int i=1;i<10;i++){
            System.out.println(data[i]);
        }
    }
}

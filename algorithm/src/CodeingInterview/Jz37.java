package CodeingInterview;

/*
    统计一个数字在升序数组中出现的次数。
 */
public class Jz37 {
    //暴力解法
    public int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0) return 0;
        int num = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k) num++;
        }

        return num;
    }

    /*
        二分法
     */
    public int GetNumberOfK1(int [] array , int k) {
        if(array==null||array.length==0) return 0;
        int down=0,up = 0;
        int l =0,r=array.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(array[mid]==k){
                up = mid;
                l = mid+1;
            }else {
                if (array[mid] < k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        l =0;
        r=array.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(array[mid]==k){
                down = mid;
                r = mid-1;
            }else {
                if (array[mid] < k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return up==down&&array[up]!=k?0:up-down+1;
    }
    public static void main(String[] args) {
        Jz37 z = new Jz37();
        System.out.println(z.GetNumberOfK1(new int[]{1,2,3,3,3,3,4,5},3));
    }
}

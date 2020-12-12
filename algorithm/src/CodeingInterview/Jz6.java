package CodeingInterview;
/*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    Input:[3,4,5,1,2]
    Output:1
 */
public class Jz6 {
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length-1;
        int mid = 0;
        while(low<high){
            mid = (low+high)/2;
            if(array[mid]>array[high]){
                low = mid + 1;
            }else if(array[mid]==array[high]){
                high = high-1;
            }else{
                high = mid ;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        Jz6 z = new Jz6();
        int [] array = {1, 1, 1, 0, 1};
        System.out.println(z.minNumberInRotateArray(array));

    }

}

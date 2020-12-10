package CodeingInterview;

/*
    在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，
    输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    input:
        7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
    outPut:
        true
 */
public class Jz1 {
    /*
    利用二分法进行判断，时间复杂度为O(n*log(n)),
    暴力搜索也可以，时间复杂度为O(n^2)
     */
    public boolean Find(int target, int [][] array) {
        int length = array[0].length;
        if(length==0){
            return false;
        }
        if(target<array[0][0]){
            return false;
        }
        for(int i=0;i<length;i++){
            int left = 0;
            int right = array[0].length-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(target==array[i][mid]){
                    return true;
                }
                if(target>array[i][mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }

    /*
    相当于新的二分，先找到最大的，然后在进行操作，这样相当于在一个维度进行二分
     */
    public boolean Find1(int target, int [][] array) {
        int length = array[0].length;
        if(length==0){
            return false;
        }
        int row = 0;
        int col = length-1;
        while(row<=length-1&&col>=0){
            if(target==array[row][col]){
                return true;
            }
            if(target>array[row][col]){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int  [][] array = {{1,2,8,9},
                           {2,4,9,12},
                           {4,7,10,13},
                           {6,8,11,15}};
        int target = 7;
        Jz1 z = new Jz1();
        System.out.println(z.Find1(target,array));
    }
}

package CodeingInterview;

import java.util.ArrayList;

/*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Jz19 {
    /*
        只能打印方阵
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null){
            return null;
        }
        ArrayList<Integer> data = new ArrayList<>();
        if(matrix.length==1){
            data.add(matrix[0][0]);
            return data;
        }
        int length = matrix.length;
        for(int i=0;i<length/2;i++){
            //右边
            for(int j=0;j<length-2*i;j++){
                data.add(matrix[i][j+i]);
            }

            //下边
            for(int j=i+1;j<length-1-i;j++){
                data.add(matrix[j][length-1-i]);
            }

            //左边
            for(int j=length-1-i;j>=i;j--){
                data.add(matrix[length-i-1][j]);
            }


            //上边
            for(int j=length-2-i;j>i;j--){
                data.add(matrix[j][i]);
            }

        }
        if(length%2==1){
            data.add(matrix[length/2][length/2]);
        }
        return data;
    }

    public ArrayList<Integer> printMatrix1(int [][] matrix) {
        ArrayList<Integer> data = new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return null;
        }
        //只需要控制好四个坐标就可以完成输出
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(true){
            for(int col = left;col<=right;col++){
                data.add(matrix[up][col]);
            }
            up++;
            if(up>down) break;

            for(int row = up;row<=down;row++){
                data.add(matrix[row][right]);
            }
            right--;
            if(left>right) break;

            for(int col = right;col>=left;col--){
                data.add(matrix[down][col]);
            }
            down--;
            if(up>down) break;


            for(int row = down;row>=up;row--){
                data.add(matrix[row][left]);
            }
            left++;
            if(left>right) break;
        }

        return data;
    }

    public static void main(String[] args) {
        Jz19 z = new Jz19();
        int [][] data= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(z.printMatrix(data));
    }
}

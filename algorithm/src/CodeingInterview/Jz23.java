package CodeingInterview;

import java.util.Arrays;

/*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
    假设输入的数组的任意两个数字都互不相同
 */
public class Jz23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }

        int mid = sequence[sequence.length-1];
        int leftEnd = 0;
        int rightBegin = 0;
        for(int i=0;i<sequence.length-1;i++){
            if(sequence[i]>mid){
                leftEnd = i;
                break;
            }
        }

        rightBegin = leftEnd;
        for(int i=leftEnd;i<sequence.length-1;i++){
            if(sequence[i]<mid){
                rightBegin = i;
                break;
            }
        }
        boolean left = true;
        boolean right = false;
        if(leftEnd==rightBegin){
             left = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,rightBegin+1));
             right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,rightBegin,sequence.length-1));
        }
        return left&right;
    }

    public static void main(String[] args) {
        Jz23 z = new Jz23();
        int [] data = {7,4,9,3,8,11,12,10};
        System.out.println(z.VerifySquenceOfBST(data));
    }
}

package CodeingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Jz22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> returnData = new ArrayList<>();
        if(root==null) return returnData;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode temp = queue.remove();
            returnData.add(temp.val);
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
        return returnData;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Jz22 z = new Jz22();
        System.out.println(z.PrintFromTopToBottom(t1));
    }
}

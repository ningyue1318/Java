package CodeingInterview;

import Basis.Queue.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
    操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Jz18 {
    /*
        递归版本
     */
    public void Mirror(TreeNode root) {
        if(root==null) return;
        if(root.right==null&&root.left==null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }

    /*
        非递归版本
     */
    public void Mirror1(TreeNode root) {
        if(root==null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            cur = queue.remove();

            temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);

        }

    }

    public static void main(String[] args) {
        Jz18 z = new Jz18();
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
        z.Mirror1(t1);
        System.out.println();
    }
}

package CodeingInterview;

/*
    输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
    平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class Jz39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;
        int left = getTreeLength(root.left);
        int right = getTreeLength(root.right);
        return Math.abs(left-right)>1?false:true;
    }

    public int getTreeLength(TreeNode root){
        if(root==null) return 0;

        return Math.max(getTreeLength(root.left),getTreeLength(root.right))+1;
    }

    public static void main(String[] args) {

    }
}

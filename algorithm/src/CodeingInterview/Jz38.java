package CodeingInterview;

/*
    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Jz38 {
    private int num=0;
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;

        tree(root,0);
        return num;
    }

    public void tree(TreeNode root,int depth){
        if(root == null) return;
        if(root.left==null&&root.right==null){
            if(depth>num) num=depth;
        }

        tree(root.left,depth+1);
        tree(root.right,depth+1);
    }

    public static void main(String[] args) {
        Jz38 z = new Jz38();
        System.out.println();
    }
}

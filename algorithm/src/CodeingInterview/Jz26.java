package CodeingInterview;

import java.util.ArrayList;

/*
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Jz26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null||(pRootOfTree.left==null&&pRootOfTree.right==null)) return pRootOfTree;

        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        subConvert(pRootOfTree,treeNodes);
        for(int i=1;i<treeNodes.size()-1;i++){
            TreeNode temp = treeNodes.get(i);
            temp.right = treeNodes.get(i+1);
            temp.left = treeNodes.get(i-1);
        }
        TreeNode temp = treeNodes.get(0);
        temp.right=treeNodes.get(1);
        temp = treeNodes.get(treeNodes.size()-1);
        temp.left =treeNodes.get(treeNodes.size()-2);
        return treeNodes.get(0);
    }

    public void subConvert(TreeNode root,ArrayList<TreeNode> nodes){
        if(root==null) return;

        subConvert(root.left,nodes);
        nodes.add(root);
        subConvert(root.right,nodes);
    }

    private TreeNode pre = null;
    private TreeNode root = null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;

        Convert1(pRootOfTree.left);
        if(root==null) root = pRootOfTree;
        if(pre!=null){
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
        }
        pre = pRootOfTree;
        Convert1(pRootOfTree.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        Jz26 z = new Jz26();
        z.Convert(t1);
    }
}

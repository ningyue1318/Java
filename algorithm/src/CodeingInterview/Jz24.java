package CodeingInterview;


import java.util.ArrayList;

/*
    输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Jz24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null||root.val>target) return result;

        subFindPath(root,target,new ArrayList<Integer>(),result);
        return result;
    }

    public void subFindPath(TreeNode root,int target,ArrayList<Integer> data,ArrayList<ArrayList<Integer>> result){
        data.add(root.val);
        if(target-root.val==0&&root.left==null&&root.right==null){
            result.add(data);
        }
        if(root.left==null&&root.right==null){
            return ;
        }
        if(root.left!=null) subFindPath(root.left,target-root.val,(ArrayList<Integer>) data.clone(),result);
        if(root.right!=null) subFindPath(root.right,target-root.val,(ArrayList<Integer>) data.clone(),result);
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
        Jz24 z = new Jz24();
        System.out.println(z.FindPath(t1,22));
    }
}


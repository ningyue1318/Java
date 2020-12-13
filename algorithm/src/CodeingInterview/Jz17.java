package CodeingInterview;

/*
    输入两棵二叉树A，B，判断B是不是A的子结构。
    我们约定空树不是任意一个树的子结构
 */
public class Jz17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null) return false;


        return DoesHasSubtree(root1,root2)||DoesHasSubtree(root1.left,root2)||DoesHasSubtree(root1.right,root2);
    }

    private boolean DoesHasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null){
            return true;
        }

        if(root1==null){
            return false;
        }

        /*
            只有不相同的时候，返回false，否则继续运算
         */
        if(root1.val!=root2.val){
            return false;
        }

        return DoesHasSubtree(root1.left,root2.left)&DoesHasSubtree(root1.right,root2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(1);
        t6.left = t7;
        Jz17 z = new Jz17();
        System.out.println(z.HasSubtree(t1,t6));
    }
}

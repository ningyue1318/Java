package CodeingInterview;


import java.util.Arrays;

/*
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
  Input:前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
  Output:{1,2,5,3,4,6,7}
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Jz4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        int data = pre[0];
        int dataIndex =0;
        //也可以把这个和下面的左子树和右子树的结合起来。判断pre和in相等的地方
        for(int i=0;i<in.length;i++){
            if(data==in[i]){
                dataIndex = i;
                break;
            }
        }
        TreeNode result = new TreeNode(data);
        result.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + dataIndex), Arrays.copyOfRange(in, 0, dataIndex));
        result.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + dataIndex, pre.length), Arrays.copyOfRange(in, dataIndex + 1, in.length));
        return result;
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,3,5,6};
        int [] in ={4,2,1,5,3,6};
        Jz4 z = new Jz4();
        TreeNode t = z.reConstructBinaryTree(pre,in);
    }
}

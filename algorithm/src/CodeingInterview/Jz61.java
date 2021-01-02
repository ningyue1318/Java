package CodeingInterview;

import Basis.Array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Jz61 {
    String result = null;

    String Serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        String result = "";
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val == -1) {
                result += " " + "#";
            } else {
                result += " " + temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                } else {
                    queue.add(new TreeNode(-1));
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                } else {
                    queue.add(new TreeNode(-1));
                }
            }
        }
        return result;
    }

    TreeNode Deserialize(String str) {
        if (str == null) return null;
        Queue<TreeNode> queue = new LinkedList();
        String[] results = str.split(" ");
        int i = results.length;
        TreeNode root = new TreeNode(Integer.parseInt(results[1]));
        queue.add(root);
        i = 2;
        for (; i < results.length; i++) {
            TreeNode temp = queue.poll();
            TreeNode left = null;
            TreeNode right = null;
            if (!results[i].equals("#")) {
                left = new TreeNode(Integer.parseInt(results[i]));
                queue.add(left);
            }
            i++;
            temp.left = left;
            if (!results[i].equals("#")) {
                right = new TreeNode(Integer.parseInt(results[i]));
                queue.add(right);
            }
            temp.right = right;
        }
        return root;
    }


    public static void main(String[] args) {
        Jz61 z = new Jz61();
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(10);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(9);
        TreeNode a7 = new TreeNode(11);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        System.out.println(z.Deserialize(z.Serialize(a1)));
    }

}

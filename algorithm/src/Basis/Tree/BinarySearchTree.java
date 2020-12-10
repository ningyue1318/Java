package Basis.Tree;

public class BinarySearchTree {
    private Node tree;

    public Node find(int data){
        Node p = tree;
        while(p!=null){
            if(data<p.data) p = p.left;
            else  p = p.right;
            if(data == p.data) return p;
        }
        return null;
    }

    public void insert(int data){
        if(tree ==null){
            tree = new Node(data);
            return;
        }

        Node p = tree;

        while(p!=null){
            if(data>p.data){
                if(p.right==null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else{
                if(p.left==null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;

            }
        }
    }

    public void preOrder(Node root){
        if(root==null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public void delete(int data){
        Node p = tree;
        Node pp = null;
        while(p!=null&&p.data!=data){
            pp = p;
            if(p.data>data)p=p.right;
            else p= p.left;
        }
        if(p==null) return;

        if(p.left!=null&&p.right!=null){
            Node minP = p.right;
            Node minPP = p;
            while(minP!=null){
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        Node child;
        if(p.left!=null) child =p.left;
        else if(p.right!=null) child = p.right;
        else child = null;

        if(pp == null) tree = child;
        else if(pp.left==p) pp.left = child;
        else pp.right = child;
    }
    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int []data = new int[]{13,10,16,9,11,14};
        for(int i=0;i<6;i++){
            tree.insert(data[i]);
        }
        //tree.preOrder(tree.tree);
        tree.inOrder(tree.tree);
    }
}

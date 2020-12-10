package Basis.Array;

public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private  Node head = new Node();

    public void printAll(){
        Node p = head;
        while(p.forwards[0]!=null){
            System.out.println(p.forwards[0]+" ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node{
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}

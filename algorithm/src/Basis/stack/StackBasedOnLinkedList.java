package stack;

public class StackBasedOnLinkedList {
    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value,null);
        if (top == null) {
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        if(top==null){
            return -1;
        }
        Node newNode = top;
        top = top.next;
        return newNode.getData();
    }

    public void printAll(){
        Node p =top;
        while(p!=null){
            System.out.println(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.printAll();
        stack.pop();
        stack.printAll();
    }
}

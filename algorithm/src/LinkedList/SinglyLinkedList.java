package LinkedList;

public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value){
        Node p = head;
        //这样可以少写一个if判断，代码更简洁
        while(p!=null&&p.data!=value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int num=0;
        while(p!=null&&num!=index){
            p=p.next;
            num++;
        }
        return p;
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertBefore(Node p,Node newNode){
        if(p==null){
            return;
        }
        if(p==head){
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while(q!=null&&q.next!=p){
            q=q.next;
        }
        newNode.next = p;
        q.next = newNode;
    }

    public void insertToTail(int value){
        Node newNode = new Node(value,null);
        if(head==null){
           head = newNode;
        }else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value){
        return new Node(value,null);
    }

    public static class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
        link.insertToTail(1);
        link.insertToTail(2);
        link.insertToTail(3);
        link.printAll();
        link.insertBefore(link.findByValue(2),new Node(4,null));
        link.printAll();
    }
}

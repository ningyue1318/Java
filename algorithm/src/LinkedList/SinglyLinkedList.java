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

    public void deleteNode(Node p){
        if(head==null||p==null){
            return;
        }

        if(p==head){
            head=null;
            return;
        }

        Node q = head;
        while(q!=null&&q.next!=p){
            q=q.next;
        }
        if(q==null){
            return;
        }

        q.next = p.next;

    }
    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        boolean flag=true;
        System.out.println("left_:"+l.data);
        System.out.println("right_:"+r.data);
        while(l != null && r != null){
            if (l.data == r.data){
                l = l.next;
                r = r.next;
                continue;
            }else{
                flag=false;
                break;
            }

        }

        System.out.println("什么结果");
        return flag;
    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p){
      Node pre = null;
      Node r = head;
      Node next = null;
      while(r!=p){
          next = r.next;

          r.next = pre;
          pre = r;
          r = next;
      }
      r.next =pre;
      return r;
    }

    public boolean palindrome(){
        if(head ==null){
            return false;
        }else{
            Node pre = head;
            if(pre.next==null){
                return true;
            }
            Node after = pre.next.next;
            if(after==null){
                return false;
            }
            while(after!=null&&pre.data!=after.data){
                after=after.next;
                pre=pre.next;
            }
            if(after==null){
                return false;
            }else{
                return TFResult(inverseLinkList(pre),after);
            }
        }
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
        /*
        link.insertToTail(1);
        link.insertToTail(2);
        link.insertToTail(3);
        link.insertToTail(4);

        Node p = link.inverseLinkList(link.findByValue(4));
        link.head =p;
        link.printAll();
        */


        int data [] ={1,2,5,2,1};
        for(int i=0;i<data.length;i++){
            link.insertToTail(data[i]);
        }
        System.out.println(link.palindrome());
    }
}

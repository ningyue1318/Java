package CodeingInterview;

import java.util.HashMap;

/*
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
    请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Jz25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) return null;
        RandomListNode  head = new RandomListNode(pHead.label);
        RandomListNode p1 = head;
        RandomListNode p2 = pHead.next;
        HashMap<Integer,RandomListNode> map= new HashMap<>();
        map.put(p1.label,p1);
        while (p2!=null){
            p1.next = new RandomListNode(p2.label);
            p1 = p1.next;
            p2 = p2.next;
            map.put(p1.label,p1);
        }
        p2 = pHead;
        p1 = head;
        while(p2!=null){
            if(p2.random!=null){
                p1.random = map.get(p2.random.label);
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r1.random = r3;
        r2.random = r5;
        r4.random = r2;
        Jz25 z = new Jz25();
        RandomListNode l = z.Clone(r1);
        System.out.println(l);
    }
}

package CodeingInterview;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;

/*
    输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Jz3 {
    /*
        运用三指针的方式
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode==null){
            return result;
        }
        if(listNode.next==null){
            result.add(listNode.val);
            return result;
        }
        if(listNode.next.next==null){
            result.add(listNode.next.val);
            result.add(listNode.val);
            return result;
        }

        ListNode pre = listNode;
        ListNode now = listNode.next;
        ListNode after = listNode.next.next;
        now.next = pre;
        pre.next = null;
        while (after!=null){
            pre = now;
            now = after;
            after = after.next;
            now.next = pre;
        }
        while(now!=null){
            result.add(now.val);
            now = now.next;
        }
        return result;
    }

    /*
        头插法
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode==null){
            return result;
        }
        if(listNode.next==null){
            result.add(listNode.val);
            return result;
        }
        if(listNode.next.next==null){
            result.add(listNode.next.val);
            result.add(listNode.val);
            return result;
        }
        ListNode reverseNode = new ListNode(-1);
        reverseNode.next =null;

        while(listNode!=null){
            ListNode node = new ListNode(listNode.val);
            node.next = reverseNode.next;
            reverseNode.next = node;
            listNode = listNode.next;
        }

        reverseNode = reverseNode.next;
        while (reverseNode!=null){
            result.add(reverseNode.val);
            reverseNode = reverseNode.next;
        }
        return result;
    }

    public static void main(String[] args) {
        //67,0,24,58
        ListNode l1 = new ListNode(67);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(24);
        ListNode l4 = new ListNode(58);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        Jz3 z = new Jz3();
        System.out.println(z.printListFromTailToHead1(l1));
    }


}

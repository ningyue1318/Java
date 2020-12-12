package CodeingInterview;

import java.util.ArrayList;

public class Jz15 {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode now = pre.next;
        if(now.next==null){
            now.next = head;
            head.next=null;
            return head;
        }
        ListNode after = now.next;
        now.next = pre;
        pre.next = null;
        while (after.next!=null){
            pre = now;
            now = after;
            after = after.next;
            now.next = pre;
        }
        after.next=now;
        return after;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        Jz15 z = new Jz15();
        z.ReverseList(l1);
    }
}

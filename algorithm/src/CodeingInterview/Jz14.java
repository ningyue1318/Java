package CodeingInterview;

import java.util.Stack;

/*
    输入一个链表，输出该链表中倒数第k个结点。
 */
public class Jz14 {

    /*
        调用栈来操作
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        int count = 0;
        while(head!=null){
            stack.push(head);
            head = head.next;
            count++;
        }
        if(k>count){
            return null;
        }
        for(int i=0;i<k-1;i++){
            stack.pop();
        }
        return stack.pop();
    }


    /*
        计算正向数目
     */
    public ListNode FindKthToTail2(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        int count = 0;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            count++;
        }
        if(k>count){
            return null;
        }
        p = head;
        for(int i=0;i<count-k;i++){
            p = p.next;
        }
        return p;
    }

    /*
        快慢指针
     */

    public ListNode FindKthToTail3(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for(int i=1;i<k;i++){
            fast = fast.next;
            if(fast==null){
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        Jz14 z = new Jz14();
        System.out.println(z.FindKthToTail3(l1,1).val);
    }
}

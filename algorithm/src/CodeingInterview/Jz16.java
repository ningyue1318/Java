package CodeingInterview;

/*
    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */
public class Jz16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode p1 = list1; //指向list1链表
        ListNode p2 = list2; //指向list2链表
        ListNode returnNode = null; //保存结果的链表
        ListNode p = null;//保存指向结果链表最后
        while(p1!=null&&p2!=null){
            ListNode temp = null;
            if(p1.val<p2.val){
                temp = p1;
                p1 = p1.next;
            }else {
                temp = p2;
                p2 = p2.next;
            }
            if(returnNode==null){
                returnNode = temp;
            }else {
                p.next = temp;
            }
            p = temp;
        }

        if(p1!=null){
            while(p1!=null){
                p.next = p1;
                p = p1;
                p1 = p1.next;
            }
        }

        if(p2!=null){
            while(p2!=null){
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }
        return returnNode;
    }

    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode returnNode = null; //保存结果的链表
        ListNode p = null;//保存指向结果链表最后
        while(list1!=null&&list2!=null){
            ListNode temp = null;
            if(list1.val<list2.val){
                temp = list1;
                list1 = list1.next;
            }else {
                temp = list2;
                list2 = list2.next;
            }

            if(returnNode==null){
                returnNode = temp;
            }else {
                p.next = temp;
            }
            p = temp;
        }
        p.next = list1==null?list2:list1;
        return returnNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(10);
        ListNode l7 = new ListNode(20);
        l1.next=l2;
        l2.next=l3;
        l3.next=l7;

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l8 = new ListNode(7);
        l4.next = l5;
        l5.next = l6;
        l6.next = l8;

        Jz16 z = new Jz16();
        z.Merge1(l1,l4);
    }
}

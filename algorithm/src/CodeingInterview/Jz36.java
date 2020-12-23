package CodeingInterview;

import java.util.HashMap;

/*
    输入两个链表，找出它们的第一个公共结点。
    （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Jz36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;

        HashMap<Integer,ListNode> map = new HashMap<>();
        while(pHead1!=null){
            if(!map.containsKey(pHead1.val)) {
                map.put(pHead1.val, pHead1);
            }
            pHead1 = pHead1.next;
        }
        ListNode returnNode;
        while(pHead2!=null){
            if(map.containsKey(pHead2.val)){
                returnNode = map.get(pHead2.val);
                break;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;
        int lengthP1 = 0;
        int lengthP2 = 0;
        ListNode p = pHead1;
        while(p!=null){
            lengthP1++;
            p = p.next;
        }
        p = pHead2;
        while (p!=null){
            lengthP2++;
            p = p.next;
        }
        if(lengthP1<lengthP2){
            p = pHead1;
            pHead2 = pHead1;
            pHead1 = p;
        }
        for(int i=0;i<Math.abs(lengthP1-lengthP2);i++){
            pHead1 = pHead1.next;
        }

        ListNode returnNode = null;
        while(pHead1!=pHead2){
            if(pHead1.val==pHead2.val){
                returnNode = pHead1;
                break;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }


    public static void main(String[] args) {

    }
}

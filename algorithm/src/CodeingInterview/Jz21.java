package CodeingInterview;

import java.util.Stack;

/*
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Jz21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int flagPop = 0;
        for(int i=0;i<pushA.length;i++){
            if(pushA[i]==popA[flagPop]){
                flagPop++;
                continue;
            }
            if(!stack.isEmpty()&&stack.peek()==popA[flagPop]){
                flagPop++;
                stack.pop();
                continue;
            }
            stack.push(pushA[i]);
        }

        for(int i = flagPop;i<popA.length;i++){
            if(stack.peek()==popA[i]){
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int flagPop = 0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);

            while (!stack.isEmpty()&&stack.peek()==popA[flagPop]){
                stack.pop();
                flagPop++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Jz21 z = new Jz21();
        int [] pushA = {1,2,3,4,5};
        int [] pushB = {4,5,3,2,1};
        System.out.println(z.IsPopOrder1(pushA, pushB));
    }
}
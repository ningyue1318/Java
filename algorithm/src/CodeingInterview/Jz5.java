package CodeingInterview;

import java.util.Stack;

/*
    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Jz5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        Jz5 z = new Jz5();
        z.push(1);
        z.push(2);
        z.push(3);
        z.push(4);
        System.out.println(z.pop());
    }

}

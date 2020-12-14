package CodeingInterview;

import java.util.ArrayList;
import java.util.Stack;

public class Jz20 {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minData = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(minData.isEmpty()){
            minData.push(node);
            return;
        }
        if(minData.peek()>=node) minData.push(node);
    }

    public void pop() {
        int popData = data.pop();
        if(popData==minData.peek()) minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minData.peek();
    }

    public static void main(String[] args) {
        Jz20 z = new Jz20();

    }
}

package src.剑指offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Soluation_5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        putStackAtoStackB(stack1, stack2);
        stack1.push(node);
    }

    public int pop() {
        putStackAtoStackB(stack2, stack1);
        return stack2.pop();
    }

    public void putStackAtoStackB(Stack stackA, Stack stackB) {
        while (!stackB.empty()) {
            Object pop = stackB.pop();
            stackA.push(pop);
        }
    }
}

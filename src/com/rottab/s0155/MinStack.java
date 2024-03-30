package com.rottab.s0155;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class MinStack {


    class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) stack.push(new Node(val, val));
        else if (stack.peek().min < val) stack.push(new Node(val, stack.peek().min));
        else stack.push(new Node(val, val));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin();// return -2
        assertEquals(minStack.getMin(), -2);
    }
}

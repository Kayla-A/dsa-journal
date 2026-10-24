package dsa.journal.lists_stacks_queues.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Pattern
        alongside each value you push, record the minimum of everything at or below it
        popping removes both together, so the min is always right

    Time Complexity
        O(1)

    Space Complexity
        O(n)

    Triggers
        a stack that must also answer min or max in O(1)
        any design problem where an extra query has to stay O(1) under push and pop

    Invariant
        for every position i, mins[i] is the minimum of stack[0..i]
*/
public class StackAuxiliaryState {
    class MinStack {
        private final Deque<Integer> stack = new ArrayDeque<>();
        private final Deque<Integer> mins = new ArrayDeque<>();

        public void push(int val) {
            stack.push(val);
            mins.push(mins.isEmpty() ? val : Math.min(val, mins.peek()));
        } // push

        public void pop() { 
            stack.pop();
            mins.pop();
        } // pop

        public int top() { 
            return stack.peek(); 
        } // top
        
        public int getMin()  { 
            return mins.peek(); 
        } // getMin

    } // MinStack

    public static void main(String[] args) {} // main

} // StackAuxiliaryState

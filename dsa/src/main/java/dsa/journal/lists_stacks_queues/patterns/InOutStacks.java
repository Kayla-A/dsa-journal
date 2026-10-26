package dsa.journal.lists_stacks_queues.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Pattern
        new elements go on in
        when you need the front, move everything from in to out
        which reverses the order so the oldest element ends up on top
        pop from out

    Time Complexity
        

    Space Complexity
        

    Triggers
        implement X using Y 
        a queue made from stacks
        any place where reversing twice restores the original order
    
        Invariant
        out holds the front of the queue with the oldest element on top
        in holds the newer elements in arrival order. Elements move from in to out only when out is empty
*/
public class InOutStacks {
    class MyQueue {
        private final Deque<Integer> in = new ArrayDeque<>();
        private final Deque<Integer> out = new ArrayDeque<>();

        public void push(int x) { in.push(x); } // push

        public int pop() { 
            shift(); 
            return out.pop(); 
        } // pop

        public int peek() { 
            shift(); 
            return out.peek(); 
        } // peek

        public boolean empty() { 
            return in.isEmpty() && out.isEmpty(); 
        } // empty

        private void shift() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) out.push(in.pop());
            } // if
        } // shift

    } // MyQueue

    public static void main(String[] args) {} // main

} // InOutStacks

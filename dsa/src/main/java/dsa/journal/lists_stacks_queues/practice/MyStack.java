package dsa.journal.lists_stacks_queues.practice;

import java.util.NoSuchElementException;

public class MyStack {
    private int[] stack;
    private int size;
    
    public MyStack() {
        stack = new int[4];
        size = 0;
    } // MyStack

    public boolean push(int val) {
        resize();
        
        stack[size++] = val;
        
        return stack[size - 1] == val;
    } // push

    public int pop() throws NoSuchElementException {
        if(size == 0) throw new NoSuchElementException();

        return stack[--size];
    } // pop

    public int peek() throws NoSuchElementException {
        if(size == 0) throw new NoSuchElementException();

        return stack[size - 1];
    } // peek

    public int size() {
        return size;
    } // size

    public boolean isEmpty() {
        return size == 0;
    } // isEmpty

    private void resize() {
        if(size >= stack.length) {
            int[] temp = new int[stack.length * 2];

            for(int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            } // for

            stack = temp;
        } // if
        return;
    } // resize
    
} // MyStack

package dsa.journal.lists_stacks_queues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dsa.journal.lists_stacks_queues.practice.MyStack;

public class MyStackTest {
    MyStack stack;
    
    @BeforeEach 
    void setUp() {
        stack = new MyStack();
    } // setUp

    @Test
    @DisplayName("Peek doesn't remove")
    void peekSize() {
        for(int i = 0; i < 10; i++) {
            assertEquals(true, stack.push(i));
            assertEquals(i, stack.peek());
            assertEquals(i+1, stack.size());
        } // for
    } // peekSize

    @Test
    @DisplayName("Empty pop/peek")
    void emptyStack() {
        assertEquals(true, stack.isEmpty());
        assertThrows(NoSuchElementException.class, () -> { stack.pop(); });
        assertThrows(NoSuchElementException.class, () -> { stack.peek(); });
    } // emptyStack

    @Test
    @DisplayName("Test LIFO Push Reszie")
    void resizeStack() {
        // push values to stack, should resize as well
        for(int i = 0; i < 100; i++) {
            assertEquals(true, stack.push(i));
            assertEquals(i+1, stack.size());
        } // for

        // pop values
        for(int i = 99; i >= 0; i--) {
            assertEquals(i, stack.pop());
            assertEquals(i, stack.size());
        } // for
    } // resizeStack

    @Test
    @DisplayName("Push/Pop Multiple Times")
    void pushPop() {
        assertEquals(true, stack.push(0));
        assertEquals(1, stack.size());

        assertEquals(true, stack.push(2));
        assertEquals(2, stack.size());

        assertEquals(true, stack.push(4));
        assertEquals(3, stack.size());

        assertEquals(4, stack.pop());
        assertEquals(2, stack.size());

        assertEquals(true, stack.push(4));
        assertEquals(3, stack.size());

        assertEquals(4, stack.pop());
        assertEquals(2, stack.size());

        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());

        assertEquals(true, stack.push(6));
        assertEquals(2, stack.size());

        assertEquals(6, stack.pop());
        assertEquals(1, stack.size());

        assertEquals(0, stack.pop());
        assertEquals(0, stack.size());

    } // pushPop
} // MyStackTest

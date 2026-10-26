package dsa.journal.lists_stacks_queues.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackForMatching {
    /*
        Pattern
            push things that are still unresolved
            when something resolves them, pop the most recent one and check it

        Time Complexity
            O(n)

        Space Complexity
            O(n)

        Triggers
            valid
            balanced
            matching pairs
            nested
            most recent
            undo
            remove adjacent duplicates
            signal: the thing you compare the current item against is the most recent unresolved one

        Invariant
            the stack holds exactly the opening brackets seen so far that haven’t been closed yet
            with the most recent on top
    */

    // check valid parenthesis 
    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                
                char open = stack.pop();
                
                if((c == ')' && open != '(')
                    || (c == ']' && open != '[')
                    || (c == '}' && open != '{')) return false;
            } // if
        } // for

        return stack.isEmpty();
    } // isValid

    public static void main(String[] args) {
        String s = "{([{([[[]]])}])}";
        String s2 = "{[([[[]]])])}";

        System.out.println("Test on valid string: " + isValid(s));
        System.out.println("Test on invalid string: " + isValid(s2));
    } // main
} // StackForMatching

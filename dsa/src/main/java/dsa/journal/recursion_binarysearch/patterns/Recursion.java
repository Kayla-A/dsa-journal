package dsa.journal.recursion_binarysearch.patterns;


public class Recursion {
    /*
        Pattern
            solve a problem by reducing it to a smaller version of itself
            stop at a case you can answer directly

        Time Complexity
            O()

        Space Complexity
            O()

        Triggers
            a definition written in terms of smaller cases (“n! = n × (n-1)!”)
            self-similar/nested structure (strings, lists, trees)
            divide in half

        Invariant
            every call receives a strictly smaller input than its caller
            so it must eventually reach the base case
    */
    
    private static int factorial(int n) {
        if(n <= 1) return 1; // base case
        return n * factorial(n - 1); // subproblem
    } // facctorial

    private static int sumDigits(int n) {
        if(n < 10) return n; // base case
        return n % 10 + sumDigits(n / 10); // subproblem
    } // sumDigits

    private static int fib(int n) {
        if(n < 2) return n; // base case
        return fib(n - 1) + fib(n - 2); // subproblem
    } // fib

    public static void main(String[] args) {
        System.out.println("factorial: " + factorial(5));
        System.out.println("sumDigits: " + sumDigits(1219));
        System.out.println("fib: " + fib(6));
    } // main   
} // Recursion

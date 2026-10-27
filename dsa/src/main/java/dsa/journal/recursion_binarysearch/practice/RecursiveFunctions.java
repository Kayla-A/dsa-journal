package dsa.journal.recursion_binarysearch.practice;

import java.security.InvalidParameterException;

public class RecursiveFunctions {
    public static long factorial(int n) throws InvalidParameterException {
        if(n < 0) throw new InvalidParameterException();
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    } // factorial

    public static int sumDigits(int n) {
        if( (0 <= n && n < 10) || (0 >= n && n > -10) ) return n;
        return Math.abs(n % 10) + sumDigits(n / 10);
    } // sumDigits

    public static int fib(int n) {
        int temp = Math.abs(n);
        if(temp == 0 || temp == 1) return temp;
        int res = fib(temp - 1) + fib(temp - 2);
        return n < 0 && Math.abs(n % 2) == 0 ? res * -1 : res;
    } // fib

    public static float power(int base, int exp) {
        //exp < 0 reciprocal
        int temp = Math.abs(exp);

        if(exp == 0) return 1;
        if(exp == 1) return base;

        float res = power(base, temp - 1) * base;

        return exp < 0 ? 1 / res : res;
    } // power

    public static boolean isPalindrome(String s, int left, int right) {
        if(left >= right) return true;
        if(s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    } // isPalindrome

    public static String reverseString(String s, int left, int right) {
        if(left >= right) return new String(s);

        char[] arr = s.toCharArray();
        char t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;

        return reverseString(new String(arr), left + 1, right - 1);
    } // reverseString

} // RecursiveFunctions

package com.geeksforgeeks.recursion;

public class StringPalindrome {

    public static void main(String[] args) {
        String input = "ababa";
        System.out.println("The given is palindrome : " + isPalindrome(input, 0 , input.length() - 1));
    }

    // O(n)
    private static boolean isPalindrome(String input, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        }

        if (input.charAt(startIndex) != input.charAt(endIndex)) {
            return false;
        }
        return isPalindrome(input, startIndex + 1, endIndex - 1);
    }
}

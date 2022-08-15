package com.geeksforgeeks.dsa.mathematics;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("The given input number is palindrome : " + isPalindromeNumber(12321));
    }

    private static boolean isPalindromeNumber(int n) {
        int rem = 0, sum = 0, input = n;

        while (n > 0) {
            rem = n % 10;
            n = n / 10;
            sum = rem + (sum * 10) ;
        }
        System.out.println(sum);
        return (sum == input) ? true : false;
    }
}

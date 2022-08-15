package com.geeksforgeeks.dsa.mathematics;

public class TrailingZeros {

    public static void main(String[] args) {
        System.out.println(countTrailingZeros(12));
    }

    /**
     * Given an integer n, write a function that returns count of trailing zeroes in n!
     * if n = 5 output = 1 since 5!=120
     * Logic is to find the the number of 5's in the given number
     * Trailing 0s in n! = Count of 5s in prime factors of n!
     *                   = floor(n/5) + floor(n/25) + floor(n/125) + ....
     * https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
     */
    private static int countTrailingZeros(int n) {
        int res = 0;

        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }
        return res;
    }
}

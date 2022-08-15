package com.geeksforgeeks.dsa.mathematics;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorialOfNumber(5));
    }

    private static int factorialOfNumber(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorialOfNumber(n - 1);
    }
}

package com.geeksforgeeks.mathematics;

/*
    Used to find GCD of two numbers
    Algorithm is GCD(a,b) = GCD(b, a%b)
 */
public class EuclidGCD {

    public static void main(String[] args) {
        System.out.println("GCD of the numbers is " + euclidGCD(24, 72));
    }

    private static int euclidGCD(int a, int b) {
        //we will use recursion here

        if (b == 0) return a;

        return euclidGCD(b, a %b);
    }
}

package com.geeksforgeeks.mathematics;

import java.util.Arrays;

/*
    Algorithm which helps in finding the prime numbers within a range of numbers.
    Eg: Find all prime numbers between 1 and 1000.
    Prime Number: See if there are no factor for a number N from 0 to sqrt(N)
 */
public class SieveOfEratoSthenes {

    public static void main(String[] args) {
        boolean[] isPrimeArr = seiveOfEratoThenes(20);

        for (int i = 1; i < isPrimeArr.length; i++) {
            System.out.println(i + " is prime " + isPrimeArr[i]);
        }
    }

    private static boolean[] seiveOfEratoThenes(int input) {
        //since array starts from 0
        boolean[] isPrime = new boolean[input + 1];
        Arrays.fill(isPrime, true);

        //since 1 is not prime and element at index 0 is not considered
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= input; i++) {
            for (int j = 2 * i; j <= input; j=j+i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}

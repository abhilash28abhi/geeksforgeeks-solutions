package com.geeksforgeeks.mathematics;

public class FastPowerModulo {

    public static void main(String[] args) {
        System.out.println("Modulo of a^b%n is " + fastPower(3978432, 5, 1000000007));
    }

    // Power of a^b = (a^2)b/2 if b is even else a^b = a * a^b-1
    // eg: 3^5 = 3*3^4 and 3^6 = 9^3
    // Modulo of large numbers can be written as
    // a^b%n = (a%n ^ b%n)%n
    // (a+b)%n = (a%n +b%n) % n and so on
    private static long fastPower(long a, long b, int n) {
        long res = 1;

        while (b > 0) {
            //if b is odd
            if ((b & 1) != 0) {
                res = (res  * a % n) % n;
            }

            a = (a % n * a % n) % n;
            b = b >> 1; //same as b/2
        }
        return res;
    }
}

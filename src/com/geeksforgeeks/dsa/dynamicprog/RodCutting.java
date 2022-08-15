package com.geeksforgeeks.dsa.dynamicprog;

/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Eg: if the length of the rod is 8 and the values of different
 * pieces are given as the following, then the maximum obtainable value is 20
 * if length = 8, price is {1,5,6,9,11,12,14,16} output is 20, when we have 5 pieces each of length 2
 */
public class RodCutting {

    public static void main(String[] args) {
        int length = 8;
        int[] price = { 1, 5, 6, 9, 11, 12, 14, 16};
        int[] dp = new int[length + 1];
        System.out.println("Maximum value obtained by cutting the rod of length " + length + " is : " +
                maxPriceForRod(length, price, dp));
    }

    //TC is O(N^2)
    //SC is O(N)
    private static int maxPriceForRod(int length, int[] price, int[] dp) {
        //outer loop is for each length size of rod
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], price[j] + dp[i - j -1]);
            }
        }
        return dp[length];
    }
}

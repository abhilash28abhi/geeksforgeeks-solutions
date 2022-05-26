package com.geeksforgeeks.dynamicprog;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
 * valued coins, find the minimum no of coins req to make the change
 * For example, for N = 18 and S = {7,5,1}, minimum no of coins req would be {5,5,7,1} so output is 4
 */
public class CoinChange {

    public static void main(String[] args) {
        int amount = 18;
        int[] coins = {7, 5, 1};
        int[]dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println("Minimum coins req for the change is : " + minCoins (amount, coins, dp));
    }

    //O(N) is O(N^M); M is coins and N is the amount
    //with DP it becomes O(M*N)
    private static int minCoins(int amount, int[] coins, int[]dp) {
        //base condition for recursion
        if (amount == 0) return 0;

        int ans = Integer.MAX_VALUE;
        int subAns;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                if (dp[amount - coins[i]] != -1) {
                    //value is already stored in memory
                    subAns = dp[amount - coins[i]];
                } else {
                    subAns = minCoins(amount - coins[i], coins, dp);
                }
                if (subAns + 1 < ans && subAns != Integer.MAX_VALUE) {
                    ans = subAns + 1;
                }
            }
        }
        return dp[amount] = ans;
    }
}

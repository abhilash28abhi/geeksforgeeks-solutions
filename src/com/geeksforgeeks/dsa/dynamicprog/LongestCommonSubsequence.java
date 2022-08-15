package com.geeksforgeeks.dsa.dynamicprog;

import java.util.Arrays;

/**
 * Given two sequences, print the longest subsequence present in both of them
 * LCS for input Sequences “ABCAB” and “AECB” is “ACB” of length 3
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "ABCAB";
        String str2 = "AECB";
        System.out.println("LCS without DP is : " + findLcsWithoutDp(str1.length(), str2.length(), str1, str2));

        //creating with additional size to accommodate the empty string scenario
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("LCS with DP is : " + findLcsWithDp(str1.length(), str2.length(), str1, str2, dp));
        int[][] tabulationMat = new int[str1.length() + 1][str2.length() + 1];
        System.out.println("LCS with tabulation method is : " + findLcsWithTabulation(str1.length(), str2.length(), str1, str2, tabulationMat));
    }

    //TC here is O(2^N)
    private static int findLcsWithoutDp(int m, int n, String str1, String str2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            //if the last char are same in both strings we have 1 common subsequence
            return 1 + findLcsWithoutDp(m - 1, n - 1, str1, str2);
        } else {
            //find common subsequence by dropping last char from both string one by one
            return Math.max(findLcsWithoutDp(m-1, n, str1, str2), findLcsWithoutDp(m, n-1, str1, str2));
        }
    }

    //TC is O(N*M)
    private static int findLcsWithDp(int m, int n, String str1, String str2, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            //if value already exists in the dp
            return dp[m][n];
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return dp[m][n] = 1 + findLcsWithDp(m-1, n-1, str1, str2, dp);
        } else {
            return dp[m][n] = Math.max(findLcsWithDp(m-1, n, str1, str2, dp), findLcsWithDp(m, n-1, str1, str2, dp));
        }
    }

    //Here each position in the array will be evaluated and filled
    //TC is O(N*M)
    private static int findLcsWithTabulation(int m, int n, String str1, String str2, int[][] tabulationMat) {
        if (m == 0 || n == 0) {
            return 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    //if the last char are same in both strings we have 1 common subsequence
                    tabulationMat[i][j] = 1 + tabulationMat[i - 1][j - 1];
                } else {
                    //find common subsequence by dropping last char from both string one by one
                    tabulationMat[i][j] = Math.max(tabulationMat[i-1][j], tabulationMat[i][j -1]);
                }
            }
        }
        return tabulationMat[m][n];
    }
}

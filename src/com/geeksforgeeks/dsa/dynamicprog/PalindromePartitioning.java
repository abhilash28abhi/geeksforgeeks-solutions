package com.geeksforgeeks.dsa.dynamicprog;


/**
 * Given a string, a partitioning of the string is a palindrome partitioning
 * if every substring of the partition is a palindrome.
 * example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”
 * Determine the fewest cuts needed for a palindrome partitioning of a given string
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String input = "abac";
        int[][] dp = new int[input.length()][input.length()];
        System.out.println("Minimum cuts req for palindrome partitioning is : " + palindromePartition(input, dp));
    }

    //Time Complexity: O(n3)
    //SC: O(n2)
    private static int palindromePartition(String input, int[][] dp) {
        int n = input.length();
        //start filling the array diagonally, initial all elements in array will have 0
        for (int gap = 1; gap < n; gap++) {
            for (int row = 0, col = gap; row < n - gap; row++, col++) {
                if (isPalindrome(input, row, col)) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        dp[row][col] = Math.min(dp[row][col] ,
                                1 + dp[row][k] + dp[k+1][col]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    private static boolean isPalindrome(String input, int i, int j) {
        while (i<j) {
            if (input.charAt(i) == input.charAt(j)) {
                return true;
            }
            i++;
            j--;
        }
        return false;
    }
}

package com.geeksforgeeks.dynamicprog;

/**
 * Given two strings str1 and str2 and below operations that can be performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * Eg: str1 = DOG, str2 = DIG, output is 1
 */
public class MinimumEditDistance {

    public static void main(String[] args) {
        String str1 = "DOG";
        String str2 = "DIG";
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i<= m; i++)dp[i][0] = i;
        for (int j = 0; j<= m; j++)dp[0][j] = j;
        System.out.println("Minimum operations required for conversion is : " +
                editMinimumWithoutDp(m, n, str1, str2));
        System.out.println("Minimum operations required for conversion with Dp is : " +
                editMinimumWithDp(m, n, str1, str2, dp));
    }

    private static int editMinimumWithoutDp(int m, int n, String str1, String str2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            //if the end char are same ignore it
            return editMinimumWithoutDp(m-1, n-1, str1, str2);
        } else {
            return 1 + min(editMinimumWithoutDp(m, n - 1, str1, str2),//insert
                           editMinimumWithoutDp(m-1, n, str1, str2), //delete
                           editMinimumWithoutDp(m-1, n-1, str1, str2));//replace
        }
    }

    private static int editMinimumWithDp(int m, int n, String str1, String str2, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1;j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    //use the diagonal index value
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + min(dp[i][j-1],//insert
                            dp[i-1][j],//delete
                            dp[i-1][j-1]);//replace
                }
            }
        }
        return dp[m][n];
    }

    static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
}

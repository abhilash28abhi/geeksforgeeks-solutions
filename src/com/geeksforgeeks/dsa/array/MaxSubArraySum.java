package com.geeksforgeeks.dsa.array;

public class MaxSubArraySum {

    public static void main(String[] args) {
        System.out.println("Maximum contiguous sum is : " + findMaxSubArraySum(new int[]{-5, 4, 6, -3, 4, -1}));
        System.out.println("Maximum contiguous sum using Kadane's Algo is : " + kadaneAlgo(new int[]{-5, 4, 6, -3, 4, -1}));
    }

    // TC O(n^2)
    private static int findMaxSubArraySum(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < input.length; i++) {
            sum = 0;
            for(int j = i; j < input.length; j++) {
                sum = sum + input[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    // TC O(n)
    private static int kadaneAlgo(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < input.length; i++) {
            sum = sum + input[i];

            if (sum > maxSum) {
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}

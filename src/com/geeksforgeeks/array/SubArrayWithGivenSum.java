package com.geeksforgeeks.array;

/**
 * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 * Sum of elements between indices
 * 2 and 4 is 20 + 3 + 10 = 33
 */
public class SubArrayWithGivenSum {

    // O(n)
    private static int subArraySum(int[] arr, int sum) {
        int curr_sum = arr[0];
        int i = 0,start = 0;

        for (i = 1 ; i <= arr.length; i++) {

            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if (curr_sum < sum) {
                curr_sum = curr_sum + arr[i];
            } else if (curr_sum == sum) {
                int p = i - 1;
                System.out.println("Subarray sum found at indexes : " + start + " and " + p);
                break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        subArraySum(new int[] {1, 4, 20, 3, 10, 5}, 33);
    }
}

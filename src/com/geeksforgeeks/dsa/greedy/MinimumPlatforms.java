package com.geeksforgeeks.dsa.greedy;

import java.util.Arrays;

/**
 *Given the arrival and departure times of all trains that reach a railway station,
 * the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00},
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * Idea is to find the maximum overlapping time durations
 */
public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum no of platforms req is : " + findMinPlatforms(arr, dep, n));
    }

    //TC is O(N*logN), due to the sorting
    //SC is O(1)
    private static int findMinPlatforms(int[] arr, int[] dep, int n) {
        int ans = 0;
        int count = 0;
        Arrays.sort(arr);//900  940  950 1100 1500 1800
        Arrays.sort(dep);//910 1120 1130 1200 1900 2000

        int i = 0,j = 0;
        while (i < n) {
            if (arr[i] <= dep[j]) {
                count++;
                ans = Math.max(ans, count);
                i++;
            } else if (arr[i] > dep[j]) {
                count--;
                j++;
            }
        }
        return ans;
    }
}

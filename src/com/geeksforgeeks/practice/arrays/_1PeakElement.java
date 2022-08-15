package com.geeksforgeeks.practice.arrays;

/**
 * An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).
 * Given an array arr[] of size N, Return the index of any one of its peak elements.
 * N = 3
 * arr[] = {1,2,3}
 * Answer: 2
 */
public class _1PeakElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,0,1,1};
        int n = arr.length;
        System.out.println("Index of the peak element is : " + peakElementIndex(arr, n));
    }

    private static int peakElementIndex(int[] arr, int n) {
        if (n == 1 || arr[0] > arr[1]) return 0;
        else if (arr[n -1] > arr[n-2]) return n-1;

        for (int i = 1; i < n - 2; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }
}

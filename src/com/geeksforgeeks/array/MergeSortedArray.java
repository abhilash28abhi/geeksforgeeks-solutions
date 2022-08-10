package com.geeksforgeeks.array;

import java.util.Arrays;

/**
 * Given two sorted arrays, the task is to merge them in a sorted manner.
 * Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
 * Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
 */
public class MergeSortedArray {

    private static int[] mergeArrays (int[] arr1, int[] arr2) {
        int[] output = new int[arr1.length + arr2.length];

        int i = 0,j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                output[k] = arr1[i];
                i++;
            } else {
                output[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length)
            output[k++] = arr1[i++];

        while (j < arr2.length)
            output[k++] = arr2[j++];
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{1,3,4,5}, new int[]{2,4,6,8})));
    }
}

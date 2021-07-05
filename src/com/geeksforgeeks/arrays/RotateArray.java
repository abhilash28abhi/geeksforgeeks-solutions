package com.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * input: 1 2 3 4 5 6 7 ; d = 2
 * output: 6 7 1 2 3 4 5
 */
public class RotateArray {

    private static void rotateArray(int[] arr, int count) {
        int[] output = new int[arr.length];
        int j = 0;

        for (int i = 0 ; i < arr.length; i++) {
            if (i < count) {
                output[j] = arr[arr.length - (count - i)];
            } else {
                output[j] = arr[i - count];
            }
            j++;
        }

        System.out.println("Rotated array is : " + Arrays.toString(output));
    }

    public static void main(String[] args) {
        rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}

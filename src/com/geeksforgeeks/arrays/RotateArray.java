package com.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * input: 1 2 3 4 5 6 7 ; d = 2
 * output: 7 6 1 2 3 4 5
 */
public class RotateArray {

    private static void rotateArray(int[] arr, int count) {
        int[] output = new int[arr.length];

        int p = count;
        for (int i = 0; i < arr.length - count; i++) {
            output[p] = arr[i];
            p++;
        }

        int k = 0;
        int i = arr.length - 1;
        while (k < count) {
            output[k++] = arr[i--];
        }
        System.out.println("Rotated array is : " + Arrays.toString(output));
    }

    public static void main(String[] args) {
        rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
    }
}

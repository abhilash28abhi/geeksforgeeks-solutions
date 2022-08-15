package com.geeksforgeeks.practice.arrays;

/**
 * Given an array A of size N of integers. Your task is to find the minimum and maximum elements in the array
 * N = 6
 * A[] = {3, 2, 1, 56, 10000, 167}
 * Output:
 * min = 1, max =  10000
 */
public class _2MinMaxElements {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 56, 10000, -1};
        int n = arr.length;
        System.out.println("Min max elements in the array is : " + findMinMax(arr, n));
    }

    //TC is O(n)
    //SC is O(1)
    private static Pair findMinMax(int[] arr, int n) {
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        for (int i = 0 ; i < n - 1 ; i++) {
            if (arr[i] > arr[i+1] && arr[i] > maxElement) {
                maxElement = arr[i];
            }
            if (arr[i] < arr[i+1] && arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        if (arr[n-1] > maxElement) {
            maxElement = arr[n-1];
        } else if (arr[n-1] < minElement) {
            minElement = arr[n-1];
        }
        Pair pair = new Pair(maxElement, minElement);
        return pair;
    }

    static class Pair {
        int max, min;
        public Pair(int first, int second)
        {
            this.max = first;
            this.min = second;
        }

        @Override public String toString() {
            return "Pair{" + "max=" + max + ", min=" + min + '}';
        }
    }
}

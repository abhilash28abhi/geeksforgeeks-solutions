package com.geeksforgeeks.arrays;

public class SearchElementSortedRotatedArray {

    public static void main(String[] args) {
        System.out.println("Element found at index : " + searchInSortedRotatedArray(new int[]{30, 40, 50, 10, 20}, 10));
    }

    private static int searchInSortedRotatedArray(int[] input, int key) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (input[mid] == key) return mid;

            //left part of array is sorted
            if (input[low] < input[mid]) {
                if (key >= input[low] && key < input[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                //right part is sorted
                if (key <= input[high] && key > input[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

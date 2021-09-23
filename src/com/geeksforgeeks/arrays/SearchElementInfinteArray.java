package com.geeksforgeeks.arrays;


//you have a sorted array of infinite numbers, how would you search an element in the array ie we can't use length on array
public class SearchElementInfinteArray {

    public static void main(String[] args) {
        System.out.println("Element in infinite array found at : " +
                searchInfinite(new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}, 10));
    }

    // TC O(logN)
    private static int searchInfinite(int[] input, int key) {
        int low = 0;
        int high = 1;

        //we will try to search the key in an exponential range of index
        while (input[high] < key) {
            low = high;
            high = 2 * high;
        }
        return binarySearch (input, low, high + 1, key);
    }

    private static int binarySearch(int[] input, int low, int high, int key) {
        int mid = low + (high - low) / 2;

        while (low <= high) {
            if (input[mid] < key) {
                low = mid;
            } else if (key == input[mid]) {
                return mid;
            } else {
                high = mid;
            }
            mid = low + (high - low) / 2;
        }
        return -1;
    }
}

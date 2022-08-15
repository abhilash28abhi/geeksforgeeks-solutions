package com.geeksforgeeks.dsa.array;

public class BinarySearchElementIndex {

    public static void main(String[] args) {
        System.out.println("Element found at index: " +
                binarySearchIndex(new int[]{1, 2, 4, 5, 6}, 3)); //output should be 2
    }

    //O(log n)
    private static int binarySearchIndex(int[] arr, int element) {
        int first = 0;
        int last = arr.length;
        int mid = first + (last - first)/2;

        while (first <= last) {
            if (element < arr[mid]) {
                last = mid - 1;
            } else if (element == arr[mid]) {
                return mid;
            } else {
                first = mid + 1;
            }
            mid = first + (last - first)/2;
        }
        return last + 1;
    }
}

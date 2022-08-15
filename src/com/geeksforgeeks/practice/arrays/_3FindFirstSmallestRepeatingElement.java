package com.geeksforgeeks.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] of size n, find the first repeating element.
 * The element should occurs more than once and the index of its first occurrence should be the smallest.
 * n = 7
 * arr[] = {1, 5, 3, 4, 3, 5, 6}
 * Output: 1
 * Explanation:
 * 5 is appearing twice and
 * its first appearance is at index 1
 * which is less than 3 whose first
 * occurring index is 3
 */
public class _3FindFirstSmallestRepeatingElement {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 3, 5, 6};
        int n = arr.length;
        System.out.println("First smallest index of repeating element is : "+ findRepeating(arr, n));
    }

    private static int findRepeating(int[] arr, int n) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (!lookup.containsKey(arr[i])) {
                //store the element and its index
                lookup.put(arr[i], i);
            } else {
                int index = lookup.get(arr[i]);
                minIndex = index < minIndex ? index : minIndex;
            }
        }
        if (lookup.size() == n) return -1;
        return minIndex;
    }
}

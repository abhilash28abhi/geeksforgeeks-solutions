package com.geeksforgeeks.dsa.array;

import java.util.*;

public class SumOfArrayElements {

    public static void main(String[] args) {
        System.out.println("Number of pairs of element with the given sum are : " + sumOfArrayElements(new int[] {1, 2, 3, 4, 5, 6}, 9));
    }

    // O(n)
    private static int sumOfArrayElements(int[] arr, int sum) {
        Map<Integer, Integer> lookupMap = new HashMap<>();

        //store each element with its count
        for (int i : arr) {
            if (!lookupMap.containsKey(i)) {
                lookupMap.put(i, 0);
            }
            lookupMap.put(i, lookupMap.get(i) + 1);
        }

        int count = 0;
        for (int i : arr) {
            //if the lookup map is having the other element
            if (lookupMap.get(sum - i) != null) {
                count = count + lookupMap.get(sum - i);
            }
            if (sum - i == i) {
                count--;
            }
        }

        return count / 2;
    }
}

package com.geeksforgeeks.dsa.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Given an array of size n and an integer k, return the count of distinct numbers in all windows of size k.
    Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
           k = 4
    Output: 3 4 4 3
 */
public class CountDistinctElements {

    public static void main(String[] args) {
        bruteForceSolution(new int[]{1, 2, 1, 3, 4, 2, 3}, 4);
        efficientSolution(new int[]{1, 2, 1, 3, 4, 2, 3}, 4);
    }

    // TC O(n)
    private static void efficientSolution(int[] input, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();

        System.out.print("Count of distinct elements are : ");
        for (int i = 0; i < k; i++) {
            if (lookup.containsKey(input[i]))
                lookup.put(input[i], lookup.get(input[i]) + 1);
            else
                lookup.put(input[i], 1);
        }
        System.out.print(lookup.size() + " ");

        for (int i = k; i < input.length; i++) {
            if (lookup.get(input[i - k]) == 1)
                //element has occured only once so remove
                lookup.remove(input[i - k]);
            else
                lookup.put(input[i - k], lookup.get(input[i - k]) - 1);

            lookup.put(input[i], lookup.getOrDefault(input[i], 0) + 1);
            System.out.print(lookup.size() + " ");
        }
    }

    //TC O(nk^2)
    private static void bruteForceSolution(int[] input, int k) {
        Set<Integer> duplicate = new HashSet<>();
        System.out.print("Count of distinct elements are : ");

        for (int i = 0; i < input.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                duplicate.add(input[j]);
            }
            System.out.print(duplicate.size() + " ");
            duplicate.clear();
        }
    }
}

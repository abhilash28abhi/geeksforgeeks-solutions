package com.geeksforgeeks.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        findSubarrayWithGivenSum(new int[]{10, 15, -5, 15, -10, 5}, 5); //output index are 3 and 4
    }

    private static void findSubarrayWithGivenSum(int[] input, int sum) {
        Map<Integer, Integer> lookup = new HashMap<>();

        int start = 0;
        int end = -1;

        int currentSum = 0;
        for (int i = 0; i < input.length; i++) {
            currentSum = currentSum + input[i];

            if (currentSum == sum) {
                start = 0;
                end = i;
                break;
            }

            if(lookup.containsKey(currentSum - sum)) {
                start = lookup.get(currentSum - sum) + 1;
                end = i;
                break;
            }
            lookup.put(currentSum , i);
        }
        System.out.println("Sum found between indexes " + start + " and " + end);
    }
}

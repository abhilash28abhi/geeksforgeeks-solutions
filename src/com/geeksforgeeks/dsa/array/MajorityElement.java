package com.geeksforgeeks.dsa.array;

import java.util.HashMap;
import java.util.Map;

/*
    Majority element in an array A[] of size n is an element that appears more than n/2 times
    Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
    Output : 4
 */
public class MajorityElement {

    public static void main(String[] args) {
        majorityElementUsingMap(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});
        mooreVotingAlgo(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});
    }

    // Time is O(n) and space is O(n)
    private static void majorityElementUsingMap(int[] input) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i : input) {
            if (lookup.containsKey(i)) {
                int count = lookup.get(i) + 1;
                if (count > (input.length / 2)) {
                    System.out.println("Majority element is : " + input[i]);
                    return;
                } else
                    lookup.put(i, count);
            } else {
                lookup.put(i, 1);
            }
        }
    }

    // Time is O(n) and space is O(1)
    private static void mooreVotingAlgo (int[] input) {
        int ansIndex = 0;
        int count = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[ansIndex]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                ansIndex = i;
                count = 1;
            }
        }

        //we will get the index of majority element here in case if its present
        isMajority(input, input.length, input[ansIndex]);
    }


    static void isMajority(int[] arr, int size, int element) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (arr[i] == element)
                count++;
        }
        if (count > size / 2)
            System.out.println("The majority element is : " + element);
    }
}

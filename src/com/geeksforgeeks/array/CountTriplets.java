package com.geeksforgeeks.array;

/**
 * Given an array of distinct positive integers arr[] of length N, the task is to count all the triplets such that
 * sum of two elements equals the third element.
 * Input: arr[] = {1, 5, 3, 2}
 * Output: 2
 * (1, 2, 3), (3, 2, 5)
 */
public class CountTriplets {

    //O(n)
    static int countTriplets(int arr[]){
        //find the frequency of each elements in input
        int[] freq = new int[100];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        int count = 0;
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (freq[arr[i] + arr[j]] > 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return 0;
    }

    public static void main(String[] args) {
        countTriplets(new int[]{1, 5, 3, 2});
    }
}

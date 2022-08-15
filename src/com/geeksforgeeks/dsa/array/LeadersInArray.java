package com.geeksforgeeks.dsa.array;

/**
 * An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class LeadersInArray {

    private static void printLeaders(int[] arr) {
        //Scan all the elements from right to left in an array and keep track of maximum till now.
        // When maximum changes its value, print it.

        int max = arr[arr.length - 1];
        System.out.println("Leader number is : " + max);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                System.out.println("Leader number is : " + arr[i]);
                max = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        printLeaders(new int[]{16, 17, 4, 3, 5, 2});
    }
}

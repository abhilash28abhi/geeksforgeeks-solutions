package com.geeksforgeeks.dsa.array;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 */
public class MissingNumber {

    private static int findMissingNumber(int[] arr) {
        int size = arr.length;

        // sum of first n is n * (n+1)/2
        //given 1 number is missing so its (n+1) * (n+2)/2 now
        int sumTotal = ((size + 1) * (size + 2))/2;
        for (int i : arr) {
            sumTotal = sumTotal - i;
        }
        System.out.println("Missing number in series is : " + sumTotal);
        return sumTotal;
    }

    public static void main(String[] args) {
        findMissingNumber(new int[]{1, 2, 4, 6, 3, 7, 8});
    }
}

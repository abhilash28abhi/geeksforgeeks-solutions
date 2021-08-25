package com.geeksforgeeks.bit_manipulation;

public class FindElementInArray {

    /**
     * finds the element that appears once in an array where every other element appears twice
     * Input:  ar[] = {7, 3, 5, 4, 5, 3, 4}
     * Output: 7
     * Idea is to use XOR operation which would cancel out elements which have occurred twice
     */
    private static int findElementsInArrayWithTwiceRepeatition(int[] input){
        int res = 0;

        for (int i : input) {
            res = res ^ i;
        }
        return res;
    }


    /*
     * find the two non-repeating elements in an array of repeating elements
     * arr[] = {2, 4, 7, 9, 2, 4}
     * output= 7,9
     */
    private static void findTwoElementsInArrayWithTwiceRepeatition(int[] input) {
        int res = 0;
        for (int i : input) {
            res = res ^ i;
        }
        res = (res & -res);

        int sum1 = 0;
        int sum2 = 0;
        for (int i : input) {
            if ((i & res) > 0) {
                sum1 = (sum1 ^ i);
            }
            else {
                sum2 = (sum2 ^ i);
            }
        }

        System.out.println("The non-repeating elements are " + sum1 + " and " + sum2);
    }

    public static void main(String[] args) {
        System.out.println(findElementsInArrayWithTwiceRepeatition(new int[]{7, 3, 5, 4, 5, 3, 4}));

        findTwoElementsInArrayWithTwiceRepeatition(new int[]{2, 3, 7, 9, 11, 2, 3, 11});
    }
}

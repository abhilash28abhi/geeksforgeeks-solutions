package com.geeksforgeeks.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class ProductOfArrayElement {

    public static void main(String[] args) {
        productOfArrayElements(new int[]{1, 2, 3 ,4, 5}, 15); // output should be elements 2,4
    }

    // 0(n)
    private static void productOfArrayElements(int[] arr, int product) {
        Set<Integer> lookup = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (product % arr[i] == 0) {
                //means this element will be a divider for the product
                if (lookup.contains(product / arr[i])) {
                    //check if the quotient exists in the hashset or not
                    System.out.println("Elements which divides the product are: " + product/arr[i] + " and " + arr[i]);
                    break;
                }
                lookup.add(arr[i]);
            }
        }
    }
}

package com.geeksforgeeks.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StockBuySell {

    public static void main(String[] args) {
        bruteForceApproach(new int[]{3, 5, 1, 7, 4, 9 ,3});
        auxillarySpaceApproach(new int[]{3, 5, 1, 7, 4, 9 ,3});
        efficientApproach(new int[]{3, 5, 1, 7, 4, 9 ,3});
    }

    // TC O(n^2)
    //SC O(1)
    private static void bruteForceApproach(int[] input) {
        int maxProfit = Integer.MIN_VALUE;
        int profit;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                profit = input[j] - input[i];
                if (profit > maxProfit) {
                    startIndex = i;
                    endIndex = j;
                    maxProfit = profit;
                }
            }
        }
        System.out.println("Max profit can be earned by buying on " + startIndex + " and selling on " + endIndex);
    }


    //TC O(n)
    //SC O(n)
    private static void auxillarySpaceApproach (int[] input) {
        int[] aux = new int[input.length];
        int maxElement = 0;

        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] > maxElement) {
                maxElement = input[i];
                aux[i] = input[i];
            } else {
                aux[i] = maxElement;
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        int profit;
        int startIndex = 0, endIndex = 0;



        for (int i = 0; i < input.length; i++) {
            profit = aux[i] - input[i];
            if (profit > maxProfit) {
                maxProfit = profit;
                startIndex = i;
                endIndex = Arrays.stream(input)
                        .boxed()
                        .collect(Collectors.toList())
                        .indexOf(aux[i]);
            }
        }

        System.out.println("Max profit can be earned by buying on " + startIndex + " and selling on " + endIndex);
    }


    //TC O(n)
    //SC O(1)
    private static void efficientApproach (int[] input) {
        int minSoFar = input[0];
        int maxProfit = 0, profit;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < minSoFar) {
                minSoFar = input[i];
            }

            profit = input[i] - minSoFar;
            if (profit > maxProfit) {
                maxProfit = profit;
                startIndex = Arrays.stream(input)
                        .boxed()
                        .collect(Collectors.toList())
                        .indexOf(minSoFar);
                endIndex = i;
            }
        }

        System.out.println("Max profit can be earned by buying on " + startIndex + " and selling on " + endIndex);
    }
}

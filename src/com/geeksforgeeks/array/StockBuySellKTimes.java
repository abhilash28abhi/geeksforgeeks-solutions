package com.geeksforgeeks.array;

/**
 * Here we can buy and sell the stocks multiple times just that the profit should be max
 * Eg: {5,2,7,3,6,1,2,4} output will be 5+3+3=11
 */
public class StockBuySellKTimes {

    public static void main(String[] args) {
        System.out.println("Max profit obtained by buying and selling K times is " + maxStockProfit(new int[]{5,2,7,3,6,1,2,4}));
    }

    //TC is O(n)
    //SC is O(1)
    private static int maxStockProfit(int[] input) {
        int maxProfit = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                maxProfit = maxProfit + input[i] - input[i-1];
            }
        }
        return maxProfit;
    }
}

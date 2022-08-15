package com.geeksforgeeks.dsa.dynamicprog;

/**
 * Given a set of items, each with a weight and a value,
 * determine the number of each item to include in a collection so that
 * the total weight is less than or equal to a given limit and the total value is as large as possible.
 */
public class Knapsack {

    public static void main(String[] args) {
        int weight = 10;
        int elementsCount = 4;
        int[] elementValue = {10, 40, 30, 50};
        int[] elementWeight = {5, 4, 6, 3};

        System.out.println("Max value that can be stored in the knapsack is " + maxKnapsackValue(weight,
                elementsCount, elementValue, elementWeight));
    }

    //TC for this is O(elementsCount * weight)
    private static int maxKnapsackValue(int weight, int elementsCount, int[] elementValue, int[] elementWeight) {
        int n = elementsCount;
        int[] [] matrix = new int[n + 1][weight + 1];

        //we can't have items with 0 weight and 0 capacity so we need to handle that scenario here
        //fill row 0 with all zeros
        for (int j = 0; j < weight + 1; j++) {
            matrix[0][j] = 0;
        }
        //fill column 0 with all zeros
        for (int i = 0; i < n + 1; i++) {
            matrix[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                    //if we don't pick that weight
                    int maxValueWithoutCurrent = matrix[i - 1][j];
                    //find the max value that can be obtained with the current item
                    int maxValueWithCurrent = 0;
                    int weightOfCurr = elementWeight[i - 1]; // We use item -1 to account for the extra row at the top this is DP
                    if (j - weightOfCurr >= 0) {
                        maxValueWithCurrent = elementValue[i - 1];
                        int remainingCapacity = j - weightOfCurr;
                        maxValueWithCurrent = maxValueWithCurrent + matrix[i - 1][remainingCapacity];
                    }
                    matrix[i] [j] = Math.max(maxValueWithoutCurrent, maxValueWithCurrent);
                }
        }
        //System.out.println(Arrays.deepToString(matrix));
        return matrix[n][weight];
    }
}

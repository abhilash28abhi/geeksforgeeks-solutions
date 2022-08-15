package com.geeksforgeeks.dsa.array;

public class RainWaterTrapping {

    public static void main(String[] args) {
        rainWaterTrapping(new int[]{3, 1, 2, 4, 0, 1, 3, 2});
    }

    //TC O(n)
    //SC O(n)
    private static void rainWaterTrapping(int[] input) {
        //will have the max height of left buildings wrt to current
        int[] maxLeftHeight = new int[input.length];

        //will have the max height of right buildings wrt to current
        int[] maxRightHeight = new int[input.length];

        //preprocess each arrays
        maxLeftHeight[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            maxLeftHeight[i] = Math.max(input[i], maxLeftHeight[i - 1]);
        }
        //System.out.println("maxLeftHeight" + Arrays.toString(maxLeftHeight));
        //maxLeftHeight[3, 3, 3, 4, 4, 4, 4, 4]

        maxRightHeight[input.length - 1] = input[input.length - 1];
        for (int i = input.length - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(input[i], maxRightHeight[i + 1]);
        }
        //System.out.println("maxRightHeight" + Arrays.toString(maxRightHeight));
        //maxRightHeight[4, 4, 4, 4, 3, 3, 3, 2]

        int totalWaterTrapped = 0;
        for (int i = 0; i < input.length; i++) {
            totalWaterTrapped = totalWaterTrapped + (Math.min(maxLeftHeight[i], maxRightHeight[i]) - input[i]);
        }
        System.out.println("Total units of water trapped is : " + totalWaterTrapped);
    }
}

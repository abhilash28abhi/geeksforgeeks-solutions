package com.geeksforgeeks.dsa.recursion;


/*
    Given a set represented as a string print all subsets of it. The subsets can be printed in any order.
    Input :  set = "abc"
    Output : "", "a", "b", "c", "ab", "ac", "bc", "abc"
 */
public class StringPowerSet {

    public static void main(String[] args) {
        powerSet("abc", 0 , "");
    }


    private static void powerSet(String input, int currentIndex, String currentString) {
        if (currentIndex == input.length()) {
            System.out.println(currentString);
            return;
        }

        powerSet(input, currentIndex + 1, currentString + input.charAt(currentIndex));
        powerSet(input, currentIndex + 1, currentString);
    }
}

package com.geeksforgeeks.recursion;

/*
    print all permutations of a given string
    Below are the permutations of string ABC
    ABC ACB BAC BCA CBA CAB

    O(n*n!) Note that there are n! permutations and it requires O(n) time to print a permutation
 */
public class StringPermutation {

    public static void main(String[] args) {
        String input = "abc";
        stringPermutations(input, 0, input.length() - 1);
    }

    private static void stringPermutations(String input, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            System.out.println(input);
            return;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            input = swap(input, startIndex, i);
            stringPermutations(input, startIndex + 1, endIndex);
            input = swap(input, startIndex , i);
        }
    }

    private static String swap(String input, int i, int j) {
        char temp;
        char[] charArray = input.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

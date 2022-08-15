package com.geeksforgeeks.dsa.string;

import java.util.HashSet;
import java.util.Set;

/**
 * An anagram of a string is another string that contains the same characters, only the order of characters can be different.
 * For example, “act” and “tac” are an anagram of each other.
 */
public class Anagram {

    private static void isAnagram(String input1, String input2) {
        char[] str1 = input1.toCharArray();
        char[] str2 = input2.toCharArray();

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char ch : str1) set1.add(ch);
        for (char ch : str2) set2.add(ch);

        if (set1.equals(set2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        isAnagram("geeksforgeeks", "forgeeksgeeks");
    }
}

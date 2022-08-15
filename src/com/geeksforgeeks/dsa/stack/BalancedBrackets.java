package com.geeksforgeeks.dsa.stack;

import java.util.Stack;

/**
 * Given an expression string exp,
 * write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalancedString("()]"));
    }

    private static boolean isBalancedString(String input) {
        char[] charArr = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char ch : charArr) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (isClosingBracket(ch)) {
                if (!stack.isEmpty() && stack.peek() == inverseCharacter(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static Character inverseCharacter(char ch) {
        switch (ch) {
        case '(' : return ')';
        case '{' : return '}';
        case '[' : return ']';
        case ')' : return '(';
        case '}' : return '{';
        case ']' : return '[';
        }
        return '-';
    }

    private static boolean isClosingBracket(char ch) {
        if (ch == ')' || ch == '}' || ch == ']') {
            return true;
        }
        return false;
    }

    private static boolean isOpeningBracket(char ch) {
        if (ch == '(' || ch == '{' || ch == '[') {
            return true;
        }
        return false;
    }
}

package com.geeksforgeeks.dsa.stack;

import java.util.Stack;

public class PrevGreaterElement {

    public static void main(String[] args) {
        prevGreaterElement(new int[]{4, 10, 5, 8, 20, 15, 3, 12}); //output shd be -1,-1,10,10,-1,20,15,15
    }

    //TC O(n)
    //SC O(n)
    private static void prevGreaterElement (int[] input) {
        Stack<Integer> stack = new Stack<>();

        System.out.print("Previous greater elements are : ");
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() >= input[i]) {
                    System.out.print(stack.peek() + ", ");
                    stack.push(input[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.print("-1, ");
                stack.push(input[i]);
            }
        }
    }
}

package com.geeksforgeeks.stack;

import java.util.Stack;

public class PreviousSmallerElement {

    public static void main(String[] args) {
        prevSmallElement(new int[]{4, 10, 5, 8, 20, 15, 3, 12}); //output shd be -1,4,4,5,8,8,-1,3
    }

    //brute force solution would give O(n^2)
    //using space we can do this in O(n) using SC of O(n)
    private static void prevSmallElement(int[] input) {
        Stack<Integer> stack = new Stack<>();
        System.out.print("Nearest elements are : ");

        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() <= input[i]) {
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

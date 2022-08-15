package com.geeksforgeeks.dsa.tree;

//         2
//     4       1
//  7      8        3
public class MaxMinElementInTree {

    public static void main(String[] args) {
        Node root = new Node(2);
        System.out.println("Max element in tree is : " + maxElement(root));
        System.out.println("Max element in tree is : " + minElement(root));
    }

    //output will be 1
    // SC is O(h) where h is height of the tree since that will be the recursion call stack
    // TC is O(n)
    private static int minElement(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        return Math.min(root.value, Math.max(minElement(root.left), minElement(root.right)));
    }

    // output will be 8
    private static int maxElement(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        return Math.max(root.value, Math.max(maxElement(root.left), maxElement(root.right)));
    }
}

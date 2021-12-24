package com.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.Map;

//         2
//     4       1
//  7      8        3
public class TopAndBottomViewOfBT {

    public static void main(String[] args) {
        Node root = new Node(2);
        printTopView(root, 0);
        printBottomView(root, 0);
    }

    //output will be 7 4 2 1 3
    // TC O(n)
    // SC O(n)
    private static void printTopView(Node root, int step) {
        Map<Integer, Node> lookup = new HashMap<>();

        if (root == null) return;
        lookup.putIfAbsent(step, root);
        printTopView(root.left, step - 1);
        printTopView(root.right, step + 1);
    }

    // output will be 7 4 8 1 3
    private static void printBottomView(Node root, int step) {
        Map<Integer, Node> lookup = new HashMap<>();

        if (root == null) return;
        lookup.put(step, root);
        printBottomView(root.left, step - 1);
        printBottomView(root.right, step + 1);
    }
}

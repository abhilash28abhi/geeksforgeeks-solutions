package com.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.List;

//         2
//     4       1
//  7      8        3
public class LeftAndRightViewOfBT {

    public static void main(String[] args) {
        Node root = new Node(2);
        printLeftView(root);
        printRightView(root);
    }

    // output will be 2 4 7
    // TC O(n)
    // SC O(n)
    private static void printLeftView(Node root) {
        List<Node> list = new ArrayList<>();

        printLeftTreeViewUtil(list, root, 0);
        for (Node node : list) {
            System.out.println(node.value + " ");
        }
    }

    //output will be 2 1 3
    private static void printRightView(Node root) {
        List<Node> list = new ArrayList<>();

        printRightTreeViewUtil(list, root, 0);
        for (Node node : list) {
            System.out.println(node.value + " ");
        }
    }

    private static void printRightTreeViewUtil(List<Node> list, Node root, int level) {
        if (root == null) return;

        if (list.get(level) == null) {
            list.add(root);
        }

        printRightTreeViewUtil(list, root.right, level + 1);
        printRightTreeViewUtil(list, root.left, level + 1);
    }

    private static void printLeftTreeViewUtil(List<Node> list, Node root, int level) {
        if (root == null) return;

        if (list.get(level) == null) {
            list.add(root);
        }

        printLeftTreeViewUtil(list, root.left, level + 1);
        printLeftTreeViewUtil(list, root.right, level + 1);
    }
}

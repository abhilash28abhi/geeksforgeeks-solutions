package com.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

//         2
//     4      1
// 7       8     3
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(2);
        inOrder(root);
        preOrder(root);
        postOrder(root);
        levelOrder(root);
    }

    // output will the nodes at each level from L to R
    //ie 2 4 1 7 8 3
    // SC is O(n) TC is O(n)
    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            } else if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // Follow L N R approach
    // Go to left then print the node then go to right
    // output should be 7 4 2 8 1 3
    private static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left); // L
        System.out.println(root.value + " "); // N
        inOrder(root.right); // R
    }

    // Follow N L R approach
    // output should be 2 4 7 1 8 3
    private static void preOrder(Node root) {
        if (root == null) return;

        System.out.println(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Follow L R N approach
    //output should be 7 4 8 3 1 2
    private static void postOrder(Node root) {
        if (root != null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value + " ");
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node (int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

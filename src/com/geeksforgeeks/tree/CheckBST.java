package com.geeksforgeeks.tree;

public class CheckBST {

    //         6
    //     4       7
    // 3       8      10
    public static void main(String[] args) {
        Node root = new Node(6);
        isBST(root);
    }

    //Perform in order traversal L N R approach
    //check  if the current node is greater than the previous node
    //TC O(N) SC O(1)
    static Node prev = null;
    private static boolean isBST(Node current) {
        if (current == null) return false;

        if (!isBST(current.left)) return false;

        if (prev != null && prev.value >= current.value) {
            return false;
        }
        prev = current;

        return isBST(current.right);
    }
}

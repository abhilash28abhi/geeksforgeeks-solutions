package com.geeksforgeeks.tree;

//         2
//     4       1
//  7      8        3
// output will be 6 which is the number of nodes
public class SizeOfBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(2);
        System.out.println("Size of the tree is: " + sizeOfTree(root));
    }

    private static int sizeOfTree(Node root) {
        if (root == null) return 0;

        return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
    }
}

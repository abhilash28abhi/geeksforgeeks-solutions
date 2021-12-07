package com.geeksforgeeks.tree;

//         2
//     4       1
//  7      8        3
// output will be 3
public class HeightOfBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(2);
        System.out.println("Height of tree is : " + heightOfTree(root));
    }

    private static int heightOfTree(Node root) {
        if (root == null) return 0;

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
}

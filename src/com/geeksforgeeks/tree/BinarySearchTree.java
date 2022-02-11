package com.geeksforgeeks.tree;

/**
 *  Tree which is same as Binary tree but with condition that the left child will be smaller
 *  than the parent and right child will be greater than the parent. Also, all the elements in left sub-tree
 *  should be smaller than the parent similarly all the elements in right sub-tree should be greater than the parent.
 *  Search, insert and delete takes O(log N)
 */
public class BinarySearchTree {

    //         6
    //     4       7
    // 3       5      10
    public static void main(String[] args) {
        Node root = new Node(6);
        search(root, 3);
        insert(root, 9);
    }

    private static Node insert(Node root, int key) {
        Node currentNode = root;
        if (currentNode == null) {
            return new Node(key);
        }

        if (key <= root.value) {
            root.left = insert(currentNode.left, key);
        } else if (key > root.value) {
            root.right = insert(currentNode.right, key);
        }
        return root;
    }

    private static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (key <= root.value) {
            search(root.left, key);
        }
        else if (key > root.value) {
            search(root.right, key);
        }
        else if (root.value == key) {
            return true;
        }
        return false;
    }
}

package com.geeksforgeeks.tree;

public class FloorCeilBST {

    //          6
    //     4           7
    // 3           8      10
    public static void main(String[] args) {
        Node root = new Node(6);
        findFloorInBST(root, 5);//output will be 4
        findCeilInBST(root, 9);//output will be 10
    }

    private static void findFloorInBST(Node root, int key) {
        int floor = Integer.MAX_VALUE;
        Node currentNode = root;
        while (currentNode != null) {
            if (key == currentNode.value) {
                floor = currentNode.value;
                break;
            }

            if (key < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                floor = currentNode.value;
                currentNode = currentNode.right;
            }
        }
        System.out.println("Floor value for the key in BST is: " + floor);
    }

    private static void findCeilInBST(Node root, int key) {
        int ceil = Integer.MIN_VALUE;

        while (root != null) {
            if (key == root.value) {
                ceil = root.value;
                break;
            }

            if (key < root.value) {
                ceil = root.value;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        System.out.println("Ceil value for the key in BST is: " + ceil);
    }
}

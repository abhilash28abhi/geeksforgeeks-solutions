package com.geeksforgeeks.tree;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSumBST {

    //          6
    //     4           7
    // 3           8      10
    public static void main(String[] args) {
        Node root = new Node(6);
        Set<Integer> set = new HashSet<>();
        findPairWithSum (root, 12, set);//output will be 8 and 4
    }

    //using in order traversal  L N R
    private static boolean findPairWithSum(Node root, int sum, Set<Integer> set) {
        if (root == null) return false;

        if (findPairWithSum(root.left, sum, set) == true) {
            return true;
        }

        if (set.contains(sum - root.value)) {
            return true;
        } else {
            set.add(root.value);
        }
        return findPairWithSum(root.right, sum, set);
    }
}

package com.geeksforgeeks.dsa.heap;

import java.util.Arrays;

/*
    Heap is a complete Binary Tree that satisfies a heap's property. A complete BT is a BT
    where in the last level of tree the nodes start from left side.
    Heap Property:
    a.  Max Heap: Where the child nodes are smaller than the parent
    b.  Min Heap: Where the child nodes are bigger than the parent
    We represent heap as an array with starting position from index 1 not 0

    Height of a complete BT = log N
    Parent of ith Node = floor (i/2)
    left child of i = i * 2
    right child of i = i * 2 + 1

    Heapify is the fastest algorithm to build a heap in O(N) when compared to typical O(Nlog N)
 */
public class Heapify {

    public static void main(String[] args) {
        //            10
        //        30      50
        //    20    35   15
        buildHeap(new int[]{-1, 10, 30, 50, 20, 35, 15});
    }

    private static void buildHeap(int[] input) {
        //we can start to heapify from a non-leaf node ie from n/2 directly
        for (int i = input.length / 2; i > 0; i--) {
            heapify(input, i, input.length);
        }
        System.out.println("Heap created after heapify is : " + Arrays.toString(input));
        //output is  50, 35, 15, 20, 30, 10
        //          50
        //      35       15
        //   20   30  10
    }

    private static void heapify(int[] input, int i, int size) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left < size && input[largest] < input[left] ) {
            largest = left;
        }
        if (right < size && input[largest] < input[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(input, i, largest);
            heapify(input, largest, size);
        }
    }

    private static void swap(int[] input, int i, int largest) {
        int temp = input[i];
        input[i] = input[largest];
        input[largest] = temp;
    }
}

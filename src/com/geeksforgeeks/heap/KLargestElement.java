package com.geeksforgeeks.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElement {

    public static void main(String[] args) {
        findKLargestElement(new Integer[]{20, 10, 60, 30, 50, 40}, 3);
        findKLargestElementUsingHeap(new int[]{20, 10, 60, 30, 50, 40}, 3);
    }


    private static void findKLargestElementUsingHeap(int[] input, int k) {
        //PQ by default uses min heap
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if (input[i] > pq.peek()) {
                pq.poll();
                pq.add(input[i]);
            }
        }

        System.out.println(pq.peek());
    }

    //TC O(nlogn)
    private static void findKLargestElement(Integer[] input, int k) {
        Arrays.sort(input, Collections.reverseOrder());//60 50 40 30 20 10
        System.out.println(input[k - 1]); // output is 40
    }
}

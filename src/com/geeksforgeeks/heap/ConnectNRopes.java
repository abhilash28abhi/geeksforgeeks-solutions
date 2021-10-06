package com.geeksforgeeks.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    There are given n ropes of different lengths, we need to connect these ropes into one rope.
    The cost to connect two ropes is equal to the sum of their lengths.
    We need to connect the ropes with minimum cost.

    Input : [4, 3, 2, 6 ]
    Output: 29
 */
public class ConnectNRopes {

    public static void main(String[] args) {
        findMinCost(new int[]{4, 3, 2, 6}); // 5 + 9 + 15
    }

    //add the min length ropes consecutively to find the min cost
    private static void findMinCost(int[] input) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i : input) {
            pq.add(i);
        }

        int minCost = 0;
        while (pq.size() > 1) {
            //when we are left with
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            minCost = minCost + sum;
            pq.add(sum);
        }
        System.out.println("Minimum cost for connecting the ropes is : " + minCost);
    }
}

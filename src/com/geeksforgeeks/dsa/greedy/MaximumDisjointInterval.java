package com.geeksforgeeks.dsa.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of N intervals, the task is to find the maximal set of mutually disjoint intervals.
 * Eg: start={1,4,12,15,7}
 * Finish={13,6,14,19,13}
 * output is 3
 */
public class MaximumDisjointInterval {

    /*
    Sort the intervals, with respect to their end points.
    Now, traverse through all the intervals, if we get two overlapping intervals, then greedily choose
    the interval with lower end point since, choosing it will ensure that intervals further can be accommodated without any overlap.
    Apply the same procedure for all the intervals and print all the intervals which satisfy the above criteria.
     */
    public static void main(String[] args) {
        int[] start = {1,4,12,15,7};
        int[] finish = {13,6,14,19,13};
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < start.length; i++) {
            lookup.put(finish[i], start[i]);
        }
        System.out.println("Maximum disjoint intervals are " + maxDisjointInterval(start, finish, lookup));
    }

    //TC is O(N)
    //SC is O(N)
    private static int maxDisjointInterval(int[] start, int[] finish, Map<Integer, Integer> lookup) {
        //sort the finish intervals
        Arrays.sort(finish);
        Map<Integer, Integer> ans = new HashMap<>();
        ans.put(lookup.get(finish[0]), finish[0]);
        int currentInterval = finish[0]; //1st finish time after sorting
        for (int i = 1; i < finish.length; i++) {
            //check if start time > currentInterval finishing time or not
            if (lookup.get(finish[i]) > currentInterval) {
                ans.put(lookup.get(finish[i]), finish[i]);
                currentInterval = finish[i];
            }
        }
        System.out.println("Elements with max disjoint intervals are : " + ans);
        return ans.size();
    }
}

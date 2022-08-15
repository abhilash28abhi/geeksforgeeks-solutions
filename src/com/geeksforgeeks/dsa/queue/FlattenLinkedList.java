package com.geeksforgeeks.dsa.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class FlattenLinkedList {

    public static void main(String[] args) {
        //not creating the entire linkedlist here jst understand the logic
        Node input = new Node (1);
//        input structure   1-->2-->3-->4-->5
//                          |           |
//                          6-->7-->8   9-->10
//                              |   |   |
//                              11  12  13-->14
//                                  |    |
//                                  15  16-->17
        //output is 1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,17
        //idea is traverse the linked list and output each level elements
        flattenLinkedList(input);
    }


    //TC O(n)
    //SC O(n)
    //Logic: Print each next element one by one, if they have any down elements store it in queue
    //After each level of iteration check for the down elements till the queue is empty
    private static void flattenLinkedList(Node head) {
        Queue<Node> queue = new ArrayDeque<>();
        System.out.println("Flatten output is : ");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.println(currentNode.value);
            if (currentNode.down != null) {
                queue.add(currentNode.down);
            }

            if (currentNode.next == null) {
                currentNode.next = queue.poll();
            }

            currentNode = currentNode.next;
        }
    }
}

class Node {
    int value;
    Node next;
    Node down;

    Node (int value) {
        this.value = value;
        this.next = null;
        this.down = null;
    }
}

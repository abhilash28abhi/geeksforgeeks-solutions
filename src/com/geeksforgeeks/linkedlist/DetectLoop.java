package com.geeksforgeeks.linkedlist;

public class DetectLoop {

    public static void main(String[] args) {
        System.out.println("Does loop exist in the linkedlist : " + detectLoop(new Node(10))); //output is true
        System.out.println("Loop exists in linkedlist at node : " + detectLoopNode(new Node(10))); //output is 3
    }

    //the linked list is 1->2->3->4->5->6->3
    // use Flyod's algo with slow and fast pointers, the node they meet will be the common point
    private static Node detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

    //Flyod's algo logic is start the pointer from the intersection point and head
    //the point where both the pointers would meet will be that node
    private static Node detectLoopNode (Node head) {
        Node meet = detectLoop(head);
        Node start = head;

        while (start != null) {
            meet = meet.next;
            start = start.next;
            if (start == meet) return start;
        }
        return null;
    }
}
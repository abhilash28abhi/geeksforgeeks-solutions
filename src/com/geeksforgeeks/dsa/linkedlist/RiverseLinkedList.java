package com.geeksforgeeks.dsa.linkedlist;

public class RiverseLinkedList {

    public static void main(String[] args) {
        //not creating the entire linkedlist here jst understand the logic
        Node head = new Node(10);
        reverse(head);
    }

    private static void reverse (Node head) {
        Node currentNode = head;
        Node prev = null;
        while (currentNode != null) {
            Node temp = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = temp;
        }
    }
}

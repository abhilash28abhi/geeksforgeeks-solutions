package com.geeksforgeeks.linkedlist;

public class Palindrome {

    public static void main(String[] args) {
        //not creating the entire linkedlist here jst understand the logic
        Node node = new Node(10);
        palindrome(node);
    }

    private static boolean palindrome(Node head) {
        //find the mid node, then reverse from middle to end
        //compare the first and last node and move forward
        if (head == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node last = reverse(middle.next);
        Node current = head;

        while (last != null) {
            if (current.data != last.data) return false;
            current = current.next;
            last = last.next;
        }
        return true;
    }

    private static Node reverse(Node middle) {
        Node current = middle;
        Node prev = null;
        while (current != null) {
            Node temp = current.next;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private static Node findMiddle(Node head) {
        Node fastPointer = head;
        Node slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}

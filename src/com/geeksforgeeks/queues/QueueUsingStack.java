package com.geeksforgeeks.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStack {

    Deque<Integer> originalStack = new ArrayDeque<>();
    Deque<Integer> secStack = new ArrayDeque<>();

    private int pop () {
        while (!originalStack.isEmpty()) {
            secStack.push(originalStack.pop());
        }

        int result = secStack.pop();

        while (!secStack.isEmpty()) {
            originalStack.push(secStack.pop());
        }
        return result;
    }

    private void push (int element) {
        originalStack.push(element);
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.pop();
        System.out.println(queue.pop()); //output is 20
    }
}

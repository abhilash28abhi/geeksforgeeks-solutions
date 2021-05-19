package com.geeksforgeeks.design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

    private Deque<Integer> cache;
    private Set<Integer> addressBook;
    private int CACHE_SIZE;

    LRUCache(int cacheSize) {
        this.cache = new LinkedList<>();
        this.addressBook = new HashSet<>();
        this.CACHE_SIZE = cacheSize;
    }

    private void refer (int value) {
        if (!addressBook.contains(value)) {
            if (CACHE_SIZE == cache.size()) {
                //if the cache is full remove the last node from linkedlist and returns the value of tail
                int lastNodeValue = cache.removeLast();
                addressBook.remove(lastNodeValue);
            }
        } else {
            //address book contains this value so remove it from the end and a new node at start
            cache.remove(value);
        }
        cache.push(value);
        addressBook.add(value);
    }

    private void display () {
        for (int i : cache) {
            System.out.println(i + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);//2 3 1
        cache.refer(3);//2 1 3
        cache.refer(2);//1 3 2
        cache.refer(4);//1 3 2 4
        cache.refer(5);//3 2 4 5
        cache.display();
    }
}

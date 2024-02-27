package com.geeksforgeeks.dsa.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * We are using a map to store the key-value pair in the cache. To implement the LRU we use a doubly linkedlist
 * where the keys are being stored and the least recently used key which would be at the end of the list will be removed
 * from it and the cache.
 */
public class LRUCache {

    private Map<String, String> cache;
    private LinkedList<String> valueStore;

    private int capacity;

    LRUCache(int size) {
        this.capacity = size;
        this.cache = new HashMap<>();
        this.valueStore = new LinkedList<>();
    }


    public void put (String key, String value) {
        if (valueStore.size() <= capacity) {
            if (valueStore.size() == capacity) {
                //if cache value store is full remove the least recently used element viz from the end of list
                //we use linked list as it can remove element in O(1) efficiently
                valueStore.removeLast();
                cache.remove(key);
            }
            cache.put(key, value);
            valueStore.addFirst(key);
        }
    }

    public String get (String key) {
        String value = cache.get(key);
        if (value != null) {
            //if the data is present then we need to update the access order
            //move the current key to top of the access list
            //to move to top of the list first remove it and re-add it
            valueStore.remove(key);
            valueStore.addFirst(key);
        } else {
            value = null;
        }
        return value;
    }

    public void display() {
        for (int i = 0; i < valueStore.size(); i++) {
            String key = valueStore.get(i);
            System.out.println(key + " => " + cache.get(key));
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("a", "apple");
        lruCache.put("b", "bat");
        lruCache.put("c", "cat");
        lruCache.display();
        System.out.println("------------");
        lruCache.put("d", "dog");
        lruCache.get("c"); // accessing c, it will be moved to top
        lruCache.get("b");// accessing b, it will be moved to top
        lruCache.display();
        System.out.println("------------");
        lruCache.put("e", "egg");
        lruCache.get("b");
        lruCache.get("c");
        lruCache.display();
        //output should be
//        c => cat
//        b => bat
//        e => egg
    }
}

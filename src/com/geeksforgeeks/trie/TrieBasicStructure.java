package com.geeksforgeeks.trie;

/**
 * Also known as prefix tree
 * TC is O(N*L), where N is the number of words, and L is an average length of the word
 */
public class TrieBasicStructure {

    public static void main(String[] args) {
        insert(null, "apple");
        insert(null, "ball");
        insert(null, "app");
        search(null, "app");
    }

    private static void insert(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (currentNode.children[curr - 'a'] == null) {
                //if current node is empty, insert it
                TrieNode node = new TrieNode();
                currentNode.children[curr - 'a'] = node;//we are filling the index of array to indicate if that character is present or not
            }
            currentNode = currentNode.children[curr - 'a'];
        }
        currentNode.isEndOfWord = true;//marks the end of insertion of a word
    }

    private static boolean search(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i);
            if (currentNode.children[curr - 'a'] != null) {
                currentNode = currentNode.children[curr - 'a'];
            } else {
                return false;
            }
        }
        return currentNode.isEndOfWord;
    }

    static class TrieNode {
        private int ALPHABET_SIZE = 26;
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode () {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
        }
    }
}

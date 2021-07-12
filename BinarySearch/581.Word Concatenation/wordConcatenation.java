// https://binarysearch.com/problems/Word-Concatenation
import java.util.*;

class Trie {
    class Node {
        boolean isWord;
        char c;
        Node[] children;

        Node(char ch) {
            this.c = ch;
            this.children = new Node[26];
            this.isWord = false;
        }
    }

    Node root;

    Trie() {
        this.root = new Node('\0');
    }

    void addWord(String str) {
        Node curr = this.root;

        for (char c : str.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    // check if the word exists in the trie
    boolean isWord(String word) {
        Node curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }

        return curr.isWord;
    }

    // check if the word is a concatenation of other words in the trie
    boolean isConcat(String word) {
        Node curr = this.root;

        char[] chWords = word.toCharArray();
        int n = chWords.length;

        for (int i = 0; i < n; i++) {
            char c = chWords[i];

            // if the current node is the ending of a word, the rest can either be 1 word in the
            // trie , a concatenation of 2 or more words or not exists in the trie as a word or
            // concatenation
            // if either of the first two things are true, the word is a concatenation
            if (curr.isWord) {
                String rest = word.substring(i);
                if (isWord(rest) || isConcat(rest))
                    return true;
            }

            if (curr.children[c - 'a'] != null) {
                curr = curr.children[c - 'a'];
            } else {
                return false;
            }
        }
        return false;
    }
}

class Solution {
    public int solve(String[] words) {
        Trie t = new Trie();
        int count = 0;
        for (String word : words) {
            t.addWord(word);
        }

        for (String word : words) {
            if (t.isConcat(word))
                count++;
        }

        return count;
    }
}
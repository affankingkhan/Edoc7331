// https://binarysearch.com/problems/Trie
import java.util.*;

class Trie {
    class Node {
        boolean isWord;
        Node[] children;
        char c;

        public Node(char ch) {
            this.c = ch;
            isWord = false;
            children = new Node[26];
        }
    }
    Node root;
    public Trie() {
        this.root = new Node('\0');
    }

    public void add(String s) {
        Node curr = root;
        char[] chS = s.toCharArray();
        for (char c : chS) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean exists(String word) {
        Node curr = root;
        char[] chS = word.toCharArray();
        for (char c : chS) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }

        return curr.isWord;
    }

    public boolean startswith(String p) {
        Node curr = root;
        char[] chS = p.toCharArray();
        for (char c : chS) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }

        return true;
    }
}
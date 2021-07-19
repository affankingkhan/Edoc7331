// https://binarysearch.com/problems/Break-String-Into-Words
import java.util.*;

class Solution {
    class Trie {
        class Node {
            char c;
            boolean isWord;
            Node[] children;

            Node(char ch) {
                this.c = ch;
                children = new Node[26];
            }
        }

        Node root;

        Trie() {
            this.root = new Node('\0');
        }

        private void addWord(String word) {
            Node curr = root;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node(c);
                }
                curr = curr.children[c - 'a'];
            }

            curr.isWord = true;
        }
        private boolean isWord(String word) {
            Node curr = root;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    return false;

                curr = curr.children[c - 'a'];
            }

            return curr.isWord;
        }

        private boolean isConcat(String word) {
            char[] wordCh = word.toCharArray();
            Node curr = this.root;

            for (int i = 0; i < wordCh.length; i++) {
                char c = wordCh[i];
                if (curr.isWord) {
                    if (this.isWord(word.substring(i)) || this.isConcat(word.substring(i)))
                        return true;
                }
                if (curr.children[c - 'a'] != null) {
                    curr = curr.children[c - 'a'];

                } else {
                    return false;
                }
            }
            return curr.isWord;
        }
    }

    public boolean solve(String[] words, String s) {
        Trie t = new Trie();

        for (String word : words) {
            t.addWord(word);
        }

        return t.isConcat(s);
    }
}
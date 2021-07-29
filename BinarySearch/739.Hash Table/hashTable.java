// https://binarysearch.com/problems/Hash-Table
import java.util.*;

class HashTable {
    int SIZE = 10000;
    class Node {
        int key;
        int val;
        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    LinkedList<Node>[] table;
    public HashTable() {
        table = new LinkedList[SIZE];
    }

    public void put(int key, int val) {
        int idx = getHash(key);

        if (table[idx] == null) {
            LinkedList<Node> ll = new LinkedList<>();
            ll.add(new Node(key, val));
            table[idx] = ll;

        } else {
            boolean found = false;
            for (Node n : table[idx]) {
                if (n.key == key) {
                    n.val = val;
                    found = true;
                    break;
                }
            }
            if (!found) {
                table[idx].add(new Node(key, val));
            }
        }
    }

    public int get(int key) {
        int idx = getHash(key);

        LinkedList<Node> ll = table[idx];

        if (ll == null)
            return -1;

        for (Node n : ll) {
            if (n.key == key)
                return n.val;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getHash(key);

        LinkedList<Node> ll = table[idx];
        if (ll == null)
            return;

        for (Node n : ll) {
            if (n.key == key) {
                ll.remove(n);
                break;
            }
        }
    }

    private int getHash(int key) {
        return key % SIZE;
    }
}
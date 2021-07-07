// https://binarysearch.com/problems/Least-Recently-Used-Cache
import java.util.*;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node curr = this.cache.get(key);
            int value = curr.value;
            // Delete Node
            deleteNode(curr);
            // Add new Node to the end
            addNodeEnd(new Node(key, value));
            return value;
        } else {
            return -1;
        }
    }

    public void set(int key, int val) {
        if (this.cache.containsKey(key)) {
            Node curr = this.cache.get(key);
            // delete Node
            deleteNode(curr);
        } else {
            if (this.cache.size() == capacity) {
                // evict LRU (head)
                deleteNode(head);
            }
        }

        // add new Node to end
        addNodeEnd(new Node(key, val));
    }

    private void addNodeEnd(Node curr) {
        int size = this.cache.size();
        if (size == 0) {
            head = curr;
            tail = curr;

        } else {
            curr.prev = tail;
            tail.next = curr;
            tail = curr;
        }
        this.cache.put(curr.key, curr);
    }

    private void deleteNode(Node curr) {
        if (this.cache.size() == 1) {
            this.head = null;
            this.tail = null;
        } else if (head == curr) {
            removeHead();
        } else if (tail == curr) {
            removeTail();
        }

        else {
            Node prev = curr.prev;
            Node next = curr.next;
            prev.next = next;
            next.prev = prev;
        }
        this.cache.remove(curr.key);
    }

    private void removeHead() {
        this.head = this.head.next;
        this.head.prev = null;
        return;
    }

    private void removeTail() {
        this.tail = this.tail.prev;
        this.tail.next = null;
        return;
    }
}
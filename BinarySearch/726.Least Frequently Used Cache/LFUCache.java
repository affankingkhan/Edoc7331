// https://binarysearch.com/problems/Least-Frequently-Used-Cache
import java.util.*;

class LFUCache {
    class Node {
        int key;
        int val;
        int counter;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.counter = 0;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<Integer, Node> cache;
    int capacity;

    // map the freq to the dll head and tail array
    // the Node[] is of length 2 Node[0] = head and Node[1] = tail
    HashMap<Integer, Node[]> map;
    int freq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        map = new HashMap<>();
        this.freq = Integer.MAX_VALUE;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            int val = curr.val;
            removeNodeFromMap(curr);
            curr.counter++;
            addNodeToMap(curr);
            return val;

        } else {
            return -1;
        }
    }

    public void set(int key, int val) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.val = val;
            removeNodeFromMap(curr);
            curr.counter++;
            addNodeToMap(curr);
        } else {
            if (this.cache.size() == capacity) {
                evict();
            }

            Node n = new Node(key, val);
            addNodeToMap(n);
            this.freq = 0;
        }
    }

    private void evict() {
        Node[] headTail = this.map.get(this.freq);
        removeNodeFromMap(headTail[1]);
    }

    private void removeNodeFromMap(Node curr) {
        int count = curr.counter;
        Node[] headTail = map.get(count);
        if (headTail[0] == headTail[1] && headTail[0] == curr) {
            headTail[0] = null;
            headTail[1] = null;
            if (this.freq == count) {
                this.freq++;
            }
        } else if (headTail[0] == curr) {
            Node next = curr.next;
            next.prev = null;
            headTail[0] = next;

        } else if (headTail[1] == curr) {
            Node prev = curr.prev;
            prev.next = null;
            headTail[1] = prev;
        } else {
            Node next = curr.next;
            Node prev = curr.prev;
            next.prev = prev;
            prev.next = next;
        }

        curr.next = null;
        curr.prev = null;

        this.cache.remove(curr.key);
    }
    private void addNodeToMap(Node curr) {
        int count = curr.counter;
        Node[] headTail = map.getOrDefault(count, new Node[2]);
        if (headTail[0] == null && headTail[1] == null) {
            headTail[0] = curr;
            headTail[1] = curr;

        } else {
            Node head = headTail[0];
            curr.next = head;
            head.prev = curr;
            curr.prev = null;
            headTail[0] = curr;
        }

        map.put(count, headTail);
        this.cache.put(curr.key, curr);
    }
}
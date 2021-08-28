// https://binarysearch.com/problems/Kth-Largest-Numbers-From-Stream
import java.util.*;

class KthLargestStream {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargestStream(int[] nums, int k) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k + 1)
                pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k + 1)
            pq.poll();

        int v = pq.peek();
        return v;
    }
}
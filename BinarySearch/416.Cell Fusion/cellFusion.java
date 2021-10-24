// https://binarysearch.com/problems/Cell-Fusion
import java.util.*;

class Solution {
    public int solve(int[] cells) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int cell : cells) {
            pq.offer(cell);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                int next = (a + b) / 3;
                pq.offer(next);
            }
        }

        return pq.isEmpty() ? -1 : pq.poll();
    }
}
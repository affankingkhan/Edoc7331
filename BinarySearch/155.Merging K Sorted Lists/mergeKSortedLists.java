// https://binarysearch.com/problems/Merging-K-Sorted-Lists
import java.util.*;

class Solution {
    public int[] solve(int[][] lists) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < lists.length; i++) {
            queue.offer(lists[i]);
        }

        while (queue.size() > 1) {
            int[] t1 = queue.poll();
            int[] t2 = queue.poll();
            int _t1 = 0;
            int _t2 = 0;
            int _t3 = 0;
            int[] temp = new int[t1.length + t2.length];
            while (_t1 < t1.length && _t2 < t2.length) {
                if (t1[_t1] > t2[_t2])
                    temp[_t3++] = t2[_t2++];
                else
                    temp[_t3++] = t1[_t1++];
            }
            while (_t1 < t1.length) temp[_t3++] = t1[_t1++];
            while (_t2 < t2.length) temp[_t3++] = t2[_t2++];
            queue.offer(temp);
        }
        return queue.poll();
    }
}
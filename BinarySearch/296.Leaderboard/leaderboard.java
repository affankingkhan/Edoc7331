// https://binarysearch.com/problems/Leaderboard
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return nums;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {i, nums[i]});
        }

        int[] ret = new int[n];

        int rank = 0;
        int[] curr = pq.poll();
        int prev = curr[1];
        ret[curr[0]] = rank;

        while (!pq.isEmpty()) {
            curr = pq.poll();
            if (curr[1] != prev) {
                rank++;
                prev = curr[1];
            }
            ret[curr[0]] = rank;
        }
        return ret;
    }
}
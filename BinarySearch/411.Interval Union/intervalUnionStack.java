// https://binarysearch.com/problems/Interval-Union
import java.util.*;

class Solution {
    public int[][] solve(int[][] intervals) {
        int n = intervals.length;
        if (n < 2)
            return intervals;

        int start = 0;
        int end = 1;

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        stack.push(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] prev = stack.peek();
            int[] curr = intervals[i];

            if (curr[start] > prev[end])
                stack.push(curr);

            // if current starts at or before previous ends
            else {
                if (curr[end] > prev[end]) {
                    prev = stack.pop();
                    prev[end] = curr[end];
                    stack.push(prev);
                }
            }
        }
        int k = stack.size();

        int[][] ret = new int[k][2];

        for (int i = k - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
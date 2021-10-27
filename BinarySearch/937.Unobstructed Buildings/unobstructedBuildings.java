// https://binarysearch.com/problems/Unobstructed-Buildings
import java.util.*;

class Solution {
    public int[] solve(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int max = 0;
        int n = heights.length;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) {
                stack.push(i);
                max = Math.max(max, heights[i]);
            }
        }

        int[] ret = new int[stack.size()];
        int j = 0;

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ret[j++] = idx;
        }

        return ret;
    }
}
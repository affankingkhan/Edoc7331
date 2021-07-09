// https://binarysearch.com/problems/Number-of-Hops
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        int count = 0;

        int l = 0;
        int r = 0;

        while (r < n - 1) {
            int furthest = r;
            for (int i = l; i <= r; i++) {
                furthest = Math.max(furthest, i + nums[i]);
            }
            l = r + 1;
            r = furthest;
            count++;
        }
        return count;
    }
}
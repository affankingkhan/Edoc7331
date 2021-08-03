// https://binarysearch.com/problems/Largest-Sum-After-K-Negations
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (k > 0 && curr < 0) {
                curr *= -1;
                k--;
            }
            sum += curr;
            min = Math.min(min, curr);
        }

        if (k == 0)
            return sum;

        k %= 2;

        if (k == 1) {
            sum -= min;
            sum += (-1 * min);
        }

        return sum;
    }
}
// https://binarysearch.com/problems/Minimum-Initial-Value-for-Positive-Prefix-Sums
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
            min = Math.min(min, sum);
        }

        return min < 1 ? Math.abs(min) + 1 : 1;
    }
}
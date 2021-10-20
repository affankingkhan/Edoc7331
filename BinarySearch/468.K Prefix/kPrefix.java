// https://binarysearch.com/problems/K-Prefix
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (prefix[i] <= k)
                return i;
        }

        return -1;
    }
}
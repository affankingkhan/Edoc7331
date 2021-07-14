// https://binarysearch.com/problems/Multiset-Sum
import java.util.*;

class Solution {
    int ans;
    public int solve(int[] nums, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= k; j++) {
                // eg.
                // dp[15] = dp[14] where nums[i] = 1
                // dp[12] = dp[10] whwe nums[i] = 2
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[k];
    }
}
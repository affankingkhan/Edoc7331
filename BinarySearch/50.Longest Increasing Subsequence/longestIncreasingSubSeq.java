//https://binarysearch.com/problems/Longest-Increasing-Subsequence
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int j = 1; j< n; j++){
            int i = 0;
            while(i < j){
                if(nums[j] > nums[i]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);

                }
                i++;
            }
        }

        return max;
    }
}
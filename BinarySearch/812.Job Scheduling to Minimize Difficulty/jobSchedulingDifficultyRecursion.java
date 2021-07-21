// https://binarysearch.com/problems/Job-Scheduling-to-Minimize-Difficulty
import java.util.*;

class Solution {
    int[] dp;
    int sum;
    public int solve(int[] jobs, int k) {
        dp = new int[k];
        sum = Integer.MAX_VALUE;
        recurse(jobs, k, 0, 0, 0, 0);
        return sum;
    }

    private void recurse(int[] jobs, int k, int i, int day, int prevSum, int currMax) {
        if (i == jobs.length && day == k - 1) {
            int ret = prevSum + currMax;
            sum = Math.min(sum, ret);
            return;
        }
        if (i >= jobs.length)
            return;

        int currDifficulty = jobs[i];
        int original = dp[day];
        dp[day] = Math.max(original, currDifficulty);
        recurse(jobs, k, i + 1, day, prevSum, dp[day]);
        dp[day] = original;
        if (day + 1 < k && i != 0) {
            dp[day + 1] = currDifficulty;
            recurse(jobs, k, i + 1, day + 1, prevSum + dp[day], dp[day + 1]);
        }
        return;
    }
}
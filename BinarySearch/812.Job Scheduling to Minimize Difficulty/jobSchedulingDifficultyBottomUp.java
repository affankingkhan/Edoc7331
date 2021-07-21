// https://binarysearch.com/problems/Job-Scheduling-to-Minimize-Difficulty
import java.util.*;

class Solution {
    public int solve(int[] jobs, int k) {
        return bottomUp(jobs, k);
    }
    public int bottomUp(int[] jobs, int k) {
        int n = jobs.length;
        if (k > n)
            return -1;

        int[][] dp = new int[k][n];

        int maxAll = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxAll = Math.max(maxAll, jobs[i]);
            dp[0][i] = maxAll;
        }

        for (int day = 1; day < k; day++) {
            for (int job = day; job < n; job++) {
                int currMax = jobs[job];
                int ans = Integer.MAX_VALUE;
                for (int i = job; i >= day; i--) {
                    currMax = Math.max(currMax, jobs[i]);
                    ans = Math.min(ans, currMax + dp[day - 1][i - 1]);
                }
                dp[day][job] = ans;
            }
        }

        return dp[k - 1][n - 1];
    }
}
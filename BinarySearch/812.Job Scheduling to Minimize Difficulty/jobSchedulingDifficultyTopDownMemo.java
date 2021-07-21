// https://binarysearch.com/problems/Job-Scheduling-to-Minimize-Difficulty
import java.util.*;

class Solution {
    int[][] memo;
    public int solve(int[] jobs, int k) {
        int n = jobs.length;
        if (k > n)
            return -1;
        memo = new int[n][k + 1];
        return recurse(jobs, n, k, 0);
    }

    private int recurse(int[] jobs, int n, int k, int cut) {
        if (k == 1) {
            return returnMax(jobs, cut);
        }
        if (memo[cut][k] > 0)
            return memo[cut][k];

        int currMax = Integer.MIN_VALUE;
        ;
        int end = n - k + 1;
        int answer = Integer.MAX_VALUE;
        for (int i = cut; i < end; i++) {
            currMax = Math.max(currMax, jobs[i]);
            answer = Math.min(answer, currMax + recurse(jobs, n, k - 1, i + 1));
        }
        memo[cut][k] = answer;
        return answer;
    }

    private int returnMax(int[] a, int start) {
        int max = Integer.MIN_VALUE;

        for (int i = start; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }
}
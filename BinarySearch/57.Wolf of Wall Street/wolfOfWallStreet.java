// https://binarysearch.com/problems/Wolf-of-Wall-Street
import java.util.*;

class Solution {
    public int solve(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;

        int min = prices[0];
        int max = Integer.MIN_VALUE;

        // as we go across, we want to keep track of the minimum value we have come across so far
        // we will use this min value and the current value to generate a potential profit
        // at each iteration we will set the max value to the max profit up until this point
        for (int i = 1; i < n; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return max > 0 ? max : 0;
    }
}
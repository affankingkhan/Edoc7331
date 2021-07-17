// https://binarysearch.com/problems/Number-of-K-Divisible-Pairs
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n = nums.length;
        if (n < 2)
            return 0;

        if (k == 1) {
            return ((n) * (n - 1)) / 2;
        }

        int[] map = new int[k + 1];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int currRemainder = num % k;
            // if the number is divisible by k
            // we also can add any mulitple of k eg. 2*k 3*k
            // map[0] will store all the ones that have remainder 0;
            if (currRemainder == 0) {
                ans += map[0];
            }

            // if the number is 0, it will have a ramainder of k
            // we also can also add 0 to this number and get a remainder or 0.
            // map[k] will store the number of 0s we have come across (those that have a remainder
            // of k);
            if (currRemainder == k) {
                ans += map[k];
            }

            int conjugateRemainder = k - currRemainder;
            int count = map[conjugateRemainder];
            ans += count;
            map[currRemainder]++;
        }

        return ans;
    }
}
// https://binarysearch.com/problems/Sliding-Window-Max
import java.util.*;

class Solution {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;
        int[] ret = new int[n - k + 1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int l = 0, r = 0;

        while (r < n) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]) {
                dq.pollLast();
            }
            dq.offerLast(r);

            if (l > dq.peekFirst()) {
                dq.pollFirst();
            }

            if (r + 1 >= k) {
                ret[l] = nums[dq.peekFirst()];
                l++;
            }
            r++;
        }
        return ret;
    }
}
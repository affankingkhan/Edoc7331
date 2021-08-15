//https://binarysearch.com/problems/First-Missing-Positive
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;

        boolean foundOne = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                foundOne = true;

            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!foundOne)
            return 1;
        

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return n + 1;
    }
}
// https://binarysearch.com/problems/Rain-Catcher
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            leftMax[i] = max;
        }

        max = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            rightMax[i] = max;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            int min = Math.min(left, right);

            count += (min - nums[i]);
        }

        return count;
    }
}
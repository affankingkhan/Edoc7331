// https://binarysearch.com/problems/Minimum-Cost-Sort
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        int[] copiedNums = Arrays.copyOf(nums, n);
        ;

        Arrays.sort(copiedNums);

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            int currLeft = Math.abs(nums[i] - copiedNums[i]);
            int currRight = Math.abs(nums[i] - copiedNums[n - 1 - i]);

            left += currLeft;
            right += currRight;
        }
        return Math.min(left, right);
    }
}
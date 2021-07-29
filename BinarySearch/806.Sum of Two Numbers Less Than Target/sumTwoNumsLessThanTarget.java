// https://binarysearch.com/problems/Sum-of-Two-Numbers-Less-Than-Target
import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0, right = n - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int l = nums[left];
            int r = nums[right];
            int sum = l + r;
            if (sum >= target)
                right--;
            else {
                max = Math.max(max, sum);
                left++;
            }
        }
        return max;
    }
}
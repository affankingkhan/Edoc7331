// https://binarysearch.com/problems/Swap-Consecutive-Index-Pairs
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i < n) {
            if (i + 2 < n) {
                swap(nums, i, i + 2);
            }
            i++;
            if (i < n && i + 2 < n) {
                swap(nums, i, i + 2);
            }
            i += 3;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
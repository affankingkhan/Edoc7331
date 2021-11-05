// https://binarysearch.com/problems/Fixed-Point
import java.util.*;

class Solution {
    int minIdx;
    public int solve(int[] nums) {
        minIdx = Integer.MAX_VALUE;
        binarySearch(nums, 0, nums.length - 1);
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }

    private void binarySearch(int[] nums, int start, int end) {
        if (start > end)
            return;
        int M = (start + end) / 2;
        if (nums[M] == M) {
            minIdx = Math.min(minIdx, M);
            binarySearch(nums, start, M - 1);

        } else {
            binarySearch(nums, start, M - 1);
            binarySearch(nums, M + 1, end);
        }
    }
}
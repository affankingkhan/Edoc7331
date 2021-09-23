// https://binarysearch.com/problems/Largest-K-Sublist-Sum
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        // get sum
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        // if k == 0, we have an empty array.
        if (k == 0)
            return 0;

        if (k == 1) {
            return kad(nums);
        }
        // if sum is negative, then we only need to go throug the first 2 coniguous arrays
        // anything after that would decrease the sum
        else if (sum < 0) {
            return kad2(nums);
        }
        // if sum is greater or equal to 0, then we we just need to determine the start in the first
        // seq, and end in the last seq. The middle will contain k-2 full sub arrays that are all
        // postive sum so must be included
        return kad2(nums) + (k - 2) * sum;
    }

    // this method runs kad on an arry that is equal to nums:nums
    private int kad2(int[] nums) {
        int[] nArr = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            nArr[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nArr[i + nums.length] = nums[i];
        }

        return this.kad(nArr);
    }

    private int kad(int[] nums) {
        int n = nums.length;
        int max = 0;
        int local = 0;
        for (int i = 0; i < n; i++) {
            if (local >= 0) {
                local += nums[i];
            } else {
                local = nums[i];
            }
            if (local > max) {
                max = local;
            }
        }

        return max;
    }
}
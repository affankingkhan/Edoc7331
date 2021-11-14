// https://binarysearch.com/problems/Median-Minimization
import java.util.*;

// 1,3,4,6,7,9
class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2] - nums[(n / 2) - 1];
    }
}
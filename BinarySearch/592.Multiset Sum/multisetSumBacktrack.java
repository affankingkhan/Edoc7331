// https://binarysearch.com/problems/Multiset-Sum
import java.util.*;

class Solution {
    int ans;
    public int solve(int[] nums, int k) {
        ans = 0;
        Arrays.sort(nums);
        recurse(nums, 0, k, 0);
        return ans;
    }

    private void recurse(int[] nums, int currSum, int k, int j) {
        if (currSum > k)
            return;
        if (currSum == k) {
            ans++;
            return;
        }
        for (int i = j; i < nums.length; i++) {
            recurse(nums, nums[i] + currSum, k, i);
        }
    }
}
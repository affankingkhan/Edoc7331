// https://binarysearch.com/problems/Sum-of-Three-Numbers
import java.util.*;

class Solution {
    public boolean solve(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int l = n - 1;
                while (j < l) {
                    int sum = nums[i] + nums[j] + nums[l];
                    if (sum == k)
                        return true;
                    else if (sum < k) {
                        j++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return false;
    }
}
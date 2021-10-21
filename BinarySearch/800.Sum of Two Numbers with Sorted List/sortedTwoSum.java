// https://binarysearch.com/problems/Sum-of-Two-Numbers-with-Sorted-List
import java.util.*;

class Solution {
    public boolean solve(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k)
                return true;
            else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
// https://binarysearch.com/problems/Verify-Max-Heap
import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int leftIdx = (2 * i) + 1;
            int rightIdx = (2 * i) + 2;
            if (leftIdx < n && nums[leftIdx] > curr)
                return false;
            if (rightIdx < n && nums[rightIdx] > curr)
                return false;
        }
        return true;
    }
}
// https://binarysearch.com/problems/Complete-an-Arithmetic-Sequence
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;

        int last = nums[n - 1];
        int first = nums[0];

        int diff = (last - first) / n;
        if (diff == 0)
            return last;

        int curr = nums[0];
        for (int i = 1; i < n; i++) {
            curr += diff;
            if (nums[i] != curr) {
                return curr;
            }
        }
        return 0;
    }
}
// https://binarysearch.com/problems/Arithmetic-Sequence-Permutation
import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return true;

        Arrays.sort(nums);

        int diff = nums[1] - nums[0];

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] != diff)
                return false;
        }

        return true;
    }
}
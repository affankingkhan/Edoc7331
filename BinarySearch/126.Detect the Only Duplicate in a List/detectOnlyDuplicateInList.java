// https://binarysearch.com/problems/Detect-the-Only-Duplicate-in-a-List
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i <= n - 1; i++) {
            ans ^= i;
        }

        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
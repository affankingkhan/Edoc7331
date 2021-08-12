// https://binarysearch.com/problems/Square-of-a-List
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
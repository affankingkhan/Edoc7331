// https://binarysearch.com/problems/Add-One-to-List
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;

        if (nums[n - 1] < 9) {
            nums[n - 1]++;
            return nums;
        }
        int[] rtn = new int[n + 1];
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i] += carry;
                return nums;
            } else
                nums[i] = 0;
        }
        rtn[0] = 1;
        return rtn;
    }
}
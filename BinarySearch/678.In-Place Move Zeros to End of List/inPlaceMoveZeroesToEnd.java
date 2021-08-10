// https://binarysearch.com/problems/In-Place-Move-Zeros-to-End-of-List
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
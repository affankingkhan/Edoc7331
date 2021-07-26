// https://binarysearch.com/problems/Consecutive-Ones
import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        int n = nums.length;
        boolean foundOne = false;
        boolean isValid = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (!foundOne) {
                    foundOne = true;
                    isValid = true;
                }

                else {
                    if (nums[i - 1] != 1) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        return isValid;
    }
}
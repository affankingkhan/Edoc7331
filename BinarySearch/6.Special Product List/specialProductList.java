//https://binarysearch.com/problems/Special-Product-List
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;

        int[] ret = new int[n];
        //left sum
        int left = 1;
        // prev value
        int prev = 1;

        for (int i = 0; i < n; i++) {
            left *= prev;
            ret[i] = left;
            prev = nums[i];
        }

        //prev value
        prev = 1;
        //right sum
        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            right *= prev;
            ret[i] *= right;
            prev = nums[i];
        }

        return ret;
    }
}
// https://binarysearch.com/problems/Longest-Sublist-of-1s-After-K-Sets
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n = nums.length;
        // behind ptr
        int i = 0;
        // ahead ptr
        int j = 0;

        // the global max sublist length
        int max = 0;
        // the current local max sublist length
        int local = 0;
        while (j < n) {
            if (nums[j] == 0) {
                if (k > 0) {
                    k--;
                    j++;
                    local++;

                } else {
                    while (nums[i] == 1) {
                        i++;
                        local--;
                    }
                    i++;
                    local--;
                    k++;
                }
            } else {
                j++;
                local++;
            }

            max = Math.max(max, local);
        }

        return max;
    }
}
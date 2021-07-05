// https://binarysearch.com/problems/Median-of-Two-Sorted-Lists
import java.util.*;

class Solution {
    public int solve(int[] nums0, int[] nums1) {
        int n0 = nums0.length;
        int n1 = nums1.length;

        int medianIndex = (n0 + n1) / 2;

        int i = 0, j = 0;
        while (i < n0 && j < n1) {
            if (i + j == medianIndex) {
                return Math.min(nums0[i], nums1[j]);
            }
            if (nums0[i] <= nums1[j]) {
                i++;
            } else {
                j++;
            }
        }

        if (i < n0) {
            int diff = medianIndex - (i + j);
            return nums0[i + diff];
        }

        int diff = medianIndex - (i + j);
        return nums1[j + diff];
    }
}
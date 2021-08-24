// https://binarysearch.com/problems/Sort-List-by-Reversing-Once
import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        int start = 0;

        while (start < n) {
            if (nums[start] != copy[start])
                break;
            else {
                start++;
            }
        }
        if (start >= n)
            return true;

        int end = n - 1;

        while (end >= 0) {
            if (nums[end] != copy[end])
                break;
            else {
                end--;
            }
        }

        int i = start;
        int j = end;

        while (i <= end && j >= start) {
            if (nums[i] != copy[j])
                return false;
            i++;
            j--;
        }

        return true;
    }
}
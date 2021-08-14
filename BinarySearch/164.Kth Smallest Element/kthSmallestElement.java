// https://binarysearch.com/problems/Kth-Smallest-Element
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n = nums.length;

        return recurse(nums, 0, n - 1, k);
    }

    private int recurse(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];

        int piv = nums[left];

        swap(nums, left, right);
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= piv) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);

        if (i == k)
            return nums[i];
        if (k < i) {
            return recurse(nums, left, i - 1, k);
        } else {
            return recurse(nums, i + 1, right, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
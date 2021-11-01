// https://binarysearch.com/problems/K-Numbers-Greater-Than-or-Equal-to-K
import java.util.*;

class Solution {
    public int saolve(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j < n && nums[j] < i) {
                j++;
            }
            if (j == n)
                break;

            if (n - j == i)
                return i;
        }

        return -1;
    }
}
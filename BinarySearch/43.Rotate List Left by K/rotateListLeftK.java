// https://binarysearch.com/problems/Rotate-List-Left-by-K
import java.util.*;

class Solution {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        if (k == 0)
            return nums;
        boolean moveRight = false;

        if (k > n / 2) {
            moveRight = true;
            k = n - k;
        }

        if (moveRight) {
            for (int i = 0; i < k; i++) {
                int prev = nums[n - 1];
                for (int j = 0; j < n; j++) {
                    int temp = nums[j];
                    nums[j] = prev;
                    prev = temp;
                }
            }

        } else {
            for (int i = 0; i < k; i++) {
                int prev = nums[0];
                for (int j = n - 1; j >= 0; j--) {
                    int temp = nums[j];
                    nums[j] = prev;
                    prev = temp;
                }
            }
        }

        return nums;
    }
}
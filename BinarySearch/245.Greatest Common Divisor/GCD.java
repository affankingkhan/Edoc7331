// https://binarysearch.com/problems/Greatest-Common-Divisor
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        for (int i = 1; i < n; i++) {
            int gcd = gcdRecurse(nums[i - 1], nums[i]);
            if (gcd == 1)
                return 1;
            nums[i] = gcd;
        }
        return nums[n - 1];
    }

    private int gcdRecurse(int a, int b) {
        if (a == 0)
            return b;
        return gcdRecurse(b % a, a);
    }

    private int gcd(int a, int b) {
        while (true) {
            int p = b / a;
            int r = b % a;
            if (r == 0)
                return a;

            b = a;
            a = r;
        }
    }
}
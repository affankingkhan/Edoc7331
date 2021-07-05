// https://binarysearch.com/problems/Median-of-Two-Sorted-Lists
import java.util.*;

class Solution {
    public int solve(int[] nums0, int[] nums1) {
        int n0 = nums0.length;
        int n1 = nums1.length;

        int totalLength = n0 + n1;

        if (n0 == 0) {
            return nums1[totalLength / 2];
        }
        if (n1 == 0) {
            return nums0[totalLength / 2];
        }

        int leftCount = totalLength / 2;

        int left = 0, right = n0;

        // System.out.println("n0: " + n0);
        // System.out.println("n1:" + n1);
        // System.out.println("leftCount:" + leftCount);

        while (true) {
            // System.out.println("left: " + left);
            // System.out.println("right: " + right);

            int m = left + (right - left) / 2;

            int l0;
            int r0;
            if (m == 0) {
                l0 = Integer.MIN_VALUE;
                r0 = nums0[m];
            } else if (m == n0) {
                l0 = nums0[m - 1];
                r0 = Integer.MAX_VALUE;
            } else {
                l0 = nums0[m - 1];
                r0 = nums0[m];
            }

            int remainderCount = leftCount - m;
            if (remainderCount < 0) {
                right = m;
                continue;
            }
            // System.out.println("m: " + m);
            // System.out.println("remainderCount: " + remainderCount );
            int l1;
            int r1;
            if (remainderCount == 0) {
                l1 = Integer.MIN_VALUE;
                r1 = nums1[0];
            } else if (remainderCount == n1) {
                l1 = nums1[n1 - 1];
                r1 = Integer.MAX_VALUE;
            }

            else {
                l1 = nums1[remainderCount - 1];
                r1 = nums1[remainderCount];
            }

            int max = Math.max(l0, l1);
            int min = Math.min(r0, r1);
            if (max <= min)
                return min;

            // determine which direction to move
            // System.out.println("l0: " + l0);
            // System.out.println("l1: " + l1);
            // System.out.println("r0: " + r0);
            // System.out.println("r1: " + r1);

            if (l0 < l1) {
                left = m + 1;
            } else {
                right = m;
            }
        }
    }
}

//https://binarysearch.com/problems/Max-Product-of-Three-Numbers
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int negProd = nums[0] * nums[1];
        int posProd = nums[n - 1] * nums[n - 2];

        return Math.max(negProd * nums[n - 1], posProd * nums[n - 3]);
    }
}
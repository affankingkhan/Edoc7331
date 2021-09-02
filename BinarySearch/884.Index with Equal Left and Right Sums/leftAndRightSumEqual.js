//https://binarysearch.com/problems/Index-with-Equal-Left-and-Right-Sums
class Solution {
    solve(nums) {
        let n = nums.length;

        let sum = 0;
        for (let i = 1; i < n; i++) {
            sum += nums[i];
        }

        let left = 0;
        let right = sum;

        for (let i = 0; i < n; i++) {
            if (left == right) return i;
            left += nums[i];
            right -= i + 1 < n ? nums[i + 1] : 0;

        }

        return -1;

    }
}
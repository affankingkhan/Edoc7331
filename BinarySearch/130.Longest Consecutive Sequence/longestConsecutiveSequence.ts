//https://binarysearch.com/problems/Longest-Consecutive-Sequence
class Solution {
    solve(nums: Array<number>): number {
        let n = nums.length;
        if (n === 0) return 0;

        nums.sort((a, b) => a - b);

        let i = 1;

        let count = 1;
        let ans = 1;


        while (i < n) {
            if (nums[i] === nums[i - 1]) {
                i++;
                continue;
            }
            else if (nums[i] === nums[i - 1] + 1) {
                count++;
            }
            else {
                count = 1;
            }
            i++;

            ans = Math.max(ans, count);
        }


        return ans;

    }
}
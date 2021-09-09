//https://binarysearch.com/problems/Max-Sum-Partitioning
class Solution {
    memo: object

    solve(nums: Array<number>, k: number): number {
        this.memo = {};

        return this.recurse(nums, 0, k);

    }

    recurse(nums: Array<number>, cut: number, k: number): number {
        // if there is only one element in the cut, just return it
        if (cut == nums.length - 1) {
            return nums[cut];
        }
        // if cut is beyond the last element, we return 0
        if (cut >= nums.length) {
            return 0;
        }
        // if cut is in memo, return it so we don't recompute
        if (cut in this.memo) {
            return this.memo[cut];
        }

        let maxSoFar = Number.MIN_SAFE_INTEGER;
        let ans = Number.MIN_SAFE_INTEGER;
        for (let i = 0; i < k; i++) {
            let idx = cut + i;
            if (idx >= nums.length) break;

            maxSoFar = Math.max(maxSoFar, nums[idx]);
            let other = this.recurse(nums, idx + 1, k);
            let pAns = maxSoFar * (i + 1);

            ans = Math.max(ans, pAns + other);

        }

        this.memo[cut] = ans;

        return ans;


    }
}
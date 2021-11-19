//https://binarysearch.com/problems/Minimize-Amplitude-After-Deleting-K-Length-Sublist
class Solution {
    solve(nums, k) {
        let n = nums.length;

        const left = new Array(n);
        const right = new Array(n);

        let min = Number.MAX_SAFE_INTEGER;
        let max = Number.MIN_SAFE_INTEGER;
        for (let i = 0; i < n; i++) {
            if (i == 0) {
                left[i] = {
                    max: null,
                    min: null
                };
            } else {
                left[i] = {
                    max,
                    min
                };
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (k == 0) return max - min;

        min = Number.MAX_SAFE_INTEGER;
        max = Number.MIN_SAFE_INTEGER;

        for (let i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = {
                    max: null,
                    min: null
                };
            } else {
                right[i] = {
                    max,
                    min
                };
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        let l = 0;
        let r = k - 1;

        let res = Number.MAX_SAFE_INTEGER;

        for (let l = 0; l <= n - k; l++) {
            let r = l + k - 1;
            const lObj = left[l];
            const rObj = right[r];

            let a = Math.max(lObj?.max ?? Number.MIN_SAFE_INTEGER, rObj?.max ?? Number
                .MIN_SAFE_INTEGER);
            let b = Math.min(lObj?.min ?? Number.MAX_SAFE_INTEGER, rObj?.min ?? Number
                .MAX_SAFE_INTEGER);
            res = Math.min(res, a - b);

        }
        return res;

    }
}
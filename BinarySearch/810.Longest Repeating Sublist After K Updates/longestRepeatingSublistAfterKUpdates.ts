// https://binarysearch.com/problems/Longest-Repeating-Sublist-After-K-Updates
class Solution {
    solve(nums: Array<number>, k: number): number {
        let left = 0;
        let right = 0;
        let max_repeated = Number.MIN_SAFE_INTEGER;
        let max_length = Number.MIN_SAFE_INTEGER;
        const map = {}
        if (!nums.length) return 0


        while (right < nums.length) {
            const c = nums[right]
            map[c] = map[c] ? map[c] + 1 : 1
            max_repeated = Math.max(max_repeated, map[c]);
            if (right - left + 1 - max_repeated > k) {
                const cL = nums[left]
                map[cL]--
                left++;
            }
            max_length = Math.max(max_length, right - left + 1);
            right++;
        }
        return max_length;


    }
}
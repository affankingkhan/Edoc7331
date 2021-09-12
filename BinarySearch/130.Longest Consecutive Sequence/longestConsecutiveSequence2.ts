//https://binarysearch.com/problems/Longest-Consecutive-Sequence
class Solution {
    solve(nums: Array<number>): number {
        let n = nums.length;
        if (n === 0) return 0;

        const map = {};

        for (let num of nums) {
            if (!map[num]) {
                map[num] = 0;
            }
            map[num]++
        }

        let ans = 0;

        let s = new Set<number>();

        for (let num of nums) {
            if (!map[num - 1] && !s.has(num)) {
                let cnt = 0;
                let curr = num;
                while (map[curr]) {
                    cnt++;
                    curr++
                }
                s.add(num);
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
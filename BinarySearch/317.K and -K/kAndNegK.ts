//https://binarysearch.com/problems/K-and-K
class Solution {
    solve(nums: Array<number>): number {
        let ret = -1;
        const s = new Set<number>();
        for (let num of nums) {
            if (num == 0) {
                ret = Math.max(ret, 0);
            } else {
                const conj = -num;
                const val = Math.abs(num);
                if (s.has(conj) && val > ret) ret = val;
            }

            s.add(num);
        }

        return ret;
    }
}
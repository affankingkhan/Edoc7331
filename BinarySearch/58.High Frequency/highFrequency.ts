//https://binarysearch.com/problems/High-Frequency
class Solution {
    solve(nums: Array<number>): number {

        const map = {};

        let max = 0;

        for (let num of nums) {
            let count = map[num] || 0;
            count++;
            max = Math.max(max, count);
            map[num] = count;
        }
        return max;

    }
}
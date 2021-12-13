//https://binarysearch.com/problems/Equivalent-Value-and-Frequency
class Solution {
    solve(nums: Array<number>): boolean {
        const map = {};

        for (let n of nums) {
            map[n] = map[n] ? (map[n] + 1) : 1;
        }

        for (let key in map) {
            if (map[key] == key) return true;
        }

        return false;
    }
}
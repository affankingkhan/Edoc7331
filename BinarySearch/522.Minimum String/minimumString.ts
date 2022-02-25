//https://binarysearch.com/problems/Minimum-String
class Solution {
    solve(s: string, t: string): number {
        const map = {};

        for (let ch of s) {
            map[ch] = map[ch] ? map[ch] + 1 : 1;
        }
        let count = 0;

        for (let ch of t) {
            if (map[ch]) {
                map[ch]--;
            }
            else {
                count++;
            }
        }
        return count;

    }
}
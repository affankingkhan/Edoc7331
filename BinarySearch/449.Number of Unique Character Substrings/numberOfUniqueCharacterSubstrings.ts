//https://binarysearch.com/problems/Number-of-Unique-Character-Substrings
class Solution {
    solve(s: string): number {
        const len = s.length

        let ans = 0;

        let curr = 0
        let prevChar = ''

        for (let i = 0; i < len; i++) {
            if (!prevChar || prevChar === s[i]) {
                curr++
            } else {
                ans += this.summation(curr)
                curr = 1

            }
            prevChar = s[i]
        }

        return !curr ? 0 : ans + this.summation(curr)

    }

    summation(n: number): number {
        return ((n) * (n + 1)) / 2
    }
}
//https://binarysearch.com/problems/Longest-Alliteration
class Solution {
    solve(words: Array<string>): number {
        let ans = 0
        let curr = 0
        let prevC = ''

        for (let word of words) {
            let c = word[0]

            if (!prevC || prevC === c) {
                curr++
                ans = Math.max(ans, curr)
            } else {
                curr = 1
            }

            prevC = c
        }

        return ans
    }
}

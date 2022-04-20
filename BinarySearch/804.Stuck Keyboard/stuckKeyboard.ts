//https://binarysearch.com/problems/Stuck-Keyboard
class Solution {
    solve(typed: string, target: string): boolean {
        let j = 0;
        let i = 0

        let n = typed.length
        let m = target.length

        if (n < m) return false

        let prevLetter = ''

        while (i < m) {
            let curr = target[i];
            if (j >= n) return false
            if (curr === typed[j]) {
                i++
                j++
            } else {
                if (typed[j] != prevLetter) return false
                while (j < n && typed[j] === prevLetter) {
                    j++
                }
                if (typed?.[j] !== curr) return false
            }
            prevLetter = curr

        }

        while (j < n && typed[j] === prevLetter) {
            j++
        }

        return j === n
    }
}
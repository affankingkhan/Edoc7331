//https://binarysearch.com/problems/Word-Formation
class Solution {
    solve(words: Array<string>, letters: string): number {
        const map = {}

        for (let ch of letters) {
            map[ch] = map[ch] ? map[ch] + 1 : 1
        }

        words.sort((a, b) => b.length - a.length)

        for (let word of words) {
            const m = { ...map }
            let fullWord = true
            for (let ch of word) {
                if (!m[ch]) {
                    fullWord = false
                    break
                } else {
                    m[ch]--
                }
            }
            if (fullWord) return word.length
        }
        return 0
    }
}
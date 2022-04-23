// 2, 17
//ti ger-tigertiger-ti ger
//https://binarysearch.com/problems/Index-Into-an-Infinite-String
class Solution {
    solve(s: string, i: number, j: number): string {
        let n = s.length
        let prefix = s.substring(i % n)

        let start = i + prefix.length

        if (start > j) {
            return s.substring(i % n, j % n)
        }
        let remainingLen = j - start
        let multiple = Math.floor(remainingLen / n)
        let mid = '';
        while (multiple > 0) {
            mid += s
            start += n
            multiple--
        }

        let suff = ''

        if (start < j) {
            suff = s.substring(start % n, j % n)

        }
        return prefix + mid + suff

    }
}
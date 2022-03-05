//https://binarysearch.com/problems/Shortest-Sublist-With-Max-Frequency
class Solution {
    solve(nums: Array<number>): number {
        const countMap = {}
        const leftMap = {}
        const rightMap = {}

        let k = 0
        nums.forEach((num, idx) => {
            if (!countMap[num]) {
                countMap[num] = 0
                leftMap[num] = idx
            }
            countMap[num]++
            rightMap[num] = idx
            k = Math.max(k, countMap[num])
        })

        if (k <= 1) return k

        const potentialArr = Object.keys(countMap).filter(num => countMap[num] === k)

        let ret = Number.MAX_SAFE_INTEGER
        for (let potential of potentialArr) {
            const left = leftMap[potential]
            const right = rightMap[potential]
            ret = Math.min(ret, right - left + 1)
        }
        return ret
    }
}
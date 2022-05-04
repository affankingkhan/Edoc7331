//https://binarysearch.com/problems/Minimize-Amplitude-After-K-Removals
class Solution {
    solve(nums: Array<number>, k: number): number {
        let n = nums.length
        let size = n - k

        nums.sort((a, b) => a - b)

        let i = 0
        let j = size - 1

        let ans = Number.MAX_SAFE_INTEGER

        while (j < n) {
            let min = nums[i++]
            let max = nums[j++]
            ans = Math.min(ans, max - min)
        }

        return ans
    }
}

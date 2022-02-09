//https://binarysearch.com/problems/A-Number-and-Its-Triple
class Solution {
    solve(nums: Array<number>): boolean {
        const s = new Set<number>()
        for (let num of nums) {
            if (this.isDivisibleBy3(num)) {
                if (s.has(num / 3)) return true
            }
            if (s.has(num * 3)) return true
            s.add(num)
        }
        return false
    }

    isDivisibleBy3(num: number): boolean {
        return num && num % 3 === 0
    }
}
//https://binarysearch.com/problems/Range-Query-on-a-List
class RangeSum {
    len: number
    prefix: Array<number>
    suffix: Array<number>
    sum: number

    constructor(nums: Array<number>) {
        const n = nums.length
        this.len = n
        this.prefix = new Array<number>(n)
        this.suffix = new Array<number>(n)
        let currSum = 0

        for (let i = 0; i < n; i++) {
            currSum += nums[i]
            this.prefix[i] = currSum
        }
        this.sum = currSum

        currSum = 0

        for (let i = n - 1; i >= 0; i--) {
            currSum += nums[i]
            this.suffix[i] = currSum
        }
    }

    total(i: number, j: number): number {
        let ans = this.sum
        if (i > 0) {
            ans -= this.prefix[i - 1]
        }

        if (j <= this.len - 1) {
            ans -= this.suffix[j]
        }

        return ans
    }
}

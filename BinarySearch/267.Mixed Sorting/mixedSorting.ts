//https://binarysearch.com/problems/Mixed-Sorting
class Solution {
    solve(nums: Array<number>): Array<number> {
        const evenArr = nums.filter(num => num % 2 == 0)
        evenArr.sort((a, b) => a - b)

        const oddArr = nums.filter(num => num % 2 != 0)
        oddArr.sort((a, b) => b - a)

        let j = 0, k = 0
        for (let i = 0; i < nums.length; i++) {
            if (nums[i] % 2 === 0) {
                nums[i] = evenArr[j++]
            }
            else {
                nums[i] = oddArr[k++]
            }

        }
        return nums
    }
}
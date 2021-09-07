//https://binarysearch.com/problems/Sort-by-Frequency-and-Value
class Solution {
    map: object;

    solve(nums: Array<number>): Array<number> {

        this.map = {};
        for (let num of nums) {
            if (this.map[num]) {
                this.map[num]++;
            } else {
                this.map[num] = 1;
            }
        }

        nums.sort((a, b) => {
            if (this.map[b] < this.map[a]) return -1;
            else if (this.map[b] > this.map[a]) return 1;
            else {
                if (b < a) return -1;
                else if (b > a) return 1;
                else {
                    return 0;
                }
            }

        })
        return nums;

    }
}
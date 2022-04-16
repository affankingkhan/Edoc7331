// 0, 1, 2, 7, 20, 19, 15, 3, 8, 80, 90, 100
//https://binarysearch.com/problems/Shortest-Sublist-to-Sort
class Solution {
    solve(nums: Array<number>): number {
        let min = Infinity;
        let max = -Infinity;

        for (let i = 0; i < nums.length; i++) {

            if (i == 0) {
                if (nums[i] > nums[i + 1]) {                         //first index check
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            } else if (i === nums.length - 1) {                   //last index check
                if (nums[i - 1] > nums[i]) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            } else {                                              //rest of the index check
                if (nums[i - 1] > nums[i] || nums[i] > nums[i + 1]) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }

        }

        //finding the position of min and max in the array
        let left = 0;
        let right = nums.length - 1;

        while (left < nums.length && nums[left] <= min)
            left++;

        while (right >= 0 && nums[right] >= max)
            right--;

        //we know if the min and max are set, both has to be set, 
        //if not we can return 0
        //else return the length of the subarray
        return (min === Infinity && max === -Infinity) ? 0 : right - left + 1;

    }
}
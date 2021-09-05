//https://binarysearch.com/problems/Strictly-Increasing-or-Strictly-Decreasing
class Solution {
	solve(nums: Array<number>): boolean {
		let n = nums.length;

		let isA = true;
		let isD = true;

		for (let i = 0; i < n - 1; i++) {
			if (!isD && !isA) break;
			if (nums[i] <= nums[i + 1]) {
				isD = false;
			}
			if (nums[i] >= nums[i + 1]) {
				isA = false;
			}
		}

		return isA || isD;
	}
}

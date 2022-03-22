//https://binarysearch.com/problems/List-Min-Replacement
class Solution {
	solve(nums: Array<number>): Array<number> {
		let min = 0;
		nums.forEach((el, i) => {
			const curr = el;
			nums[i] = min;
			if (i == 0) {
				min = curr;
			} else {
				min = Math.min(min, curr);
			}
		});
		return nums;
	}
}

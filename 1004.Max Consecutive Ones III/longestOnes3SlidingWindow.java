//https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
class Solution {
    
    public int longestOnes(int[] nums, int k) {
        int max = 0;

        int s = 0, e = 0, nk = 0;
        while (e < nums.length) {
            if (nums[e] == 1) {
                e++;
            }
            else {
                if (nk < k) {
                    nk++;
                    e++;
                }
                else {
                    while (nums[s] == 1){
                        s++;
                    }
                    s++;
                    nk--;
                }
            }
            max = Math.max(max, e - s);
        }

        return max;
    }
}
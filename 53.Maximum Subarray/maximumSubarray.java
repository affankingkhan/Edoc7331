class Solution {
    public int maxSubArray(int[] nums) {
        int[] ret = new int[nums.length];
        
        // ret[0] = nums[0];
        int max = nums[0];
        int currMax = nums[0];
        
        for(int i = 1; i< nums.length; i++){
            currMax = Math.max(nums[i], nums[i] + currMax);
            if(currMax > max){
                max = currMax;
            }
        }
        return max;
    }
}
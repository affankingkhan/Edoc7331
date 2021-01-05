class Solution {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        int expectedSum = 0;
        for(int i = 0; i<nums.length; i++){
            expectedSum += i;
            actualSum += nums[i];
        }
        
        if(expectedSum == actualSum){
            return nums.length;
        }
        
        return nums.length - (actualSum - expectedSum);
        
        
    }
}
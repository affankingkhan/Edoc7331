class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret,1);
        int acc = 1;
        
        for(int i = 1; i<nums.length;i++){
            acc *= nums[i-1];
            ret[i] *= acc;
        }
        
        acc = 1;
        for(int i = nums.length - 2; i>=0; i--){
            acc *= nums[i +1];
            ret[i] *= acc;
        }
        return ret;
    }
}
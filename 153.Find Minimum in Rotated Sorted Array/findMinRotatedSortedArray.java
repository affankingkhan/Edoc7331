class Solution {
    int min;
    public int findMin(int[] nums) {
        min = Integer.MAX_VALUE;
        dAndC(nums, 0, nums.length -1);
        return min;  
    }
    
    private void dAndC(int[] nums, int i, int j){
        if(i == j){
            min = Math.min(min, nums[i]);
            return;
        }
        int m = (i + j ) / 2;
        if(nums[m] > nums[m+1]) {
            min = Math.min(min, nums[m+1]);
            return;
        }else{
            min = Math.min(min, nums[m]);
        }
        
        dAndC(nums,i,m);
        dAndC(nums,m+1, j);
        return;
        
    }
    
    
}
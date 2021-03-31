class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int n = nums.length;
        boolean ContainsOne = false;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                ContainsOne = true;
            }
            if(nums[i] > n || nums[i] <= 0){
                nums[i] = 1;
            }
        }
        if(!ContainsOne){
            return 1;
        }
        
        for(int x = 0; x<nums.length; x++){
            int index = Math.abs(nums[x]) % n;      
            if(nums[index] >0){
                nums[index] *= -1;
            }
        }
    
        
        for(int i = 1; i< nums.length + 1; i++){
            if(nums[i%n] > 0){
                return i%n;
            }
        }
        if(nums[0] > 0){
            return n;
        }
        return n +1;
        
        
    }
}
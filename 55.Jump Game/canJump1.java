class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0; i<n; i++){
            if(nums[i] == 0 && i != n-1){
                int j = i - 1;
                boolean escapeExists = false;
                while(j >= 0 ){
                    if(nums[j] > (i -j)){
                        escapeExists = true;
                        break;
                    }
                    j--;
                }
                if(!escapeExists) return false;
                
            }
        }
        
        return true;
        
    }
}
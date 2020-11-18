class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length - 2; i++){
            int lead = nums[i];
            if(i == 0 || nums[i-1] != lead){
                int j = i + 1;
                int k = nums.length -1;
                while(j < k){
                    int sum = lead + nums[j] + nums[k];
                    int diff = target - sum;
                    if(diff == 0){
                        return target;
                    }
                    closest = (Math.abs(diff) < Math.abs(closest)) ? diff : closest; 
                    
                    if(diff < 0){
                        k--;
                    }
                    else{
                        j++;
                    }
                }
            }
        }
        return target - closest;
        
    }
}
class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        
        for(int i = 1; i<n; i++){
            int currVal = nums[i];
            int max = dp[i-1];
            int count = 1;
            for(int j = i-2; j>=0; j--){
                if(count >= k) break;
                max = Math.max(max, dp[j]);
                count++;
            }
            
            dp[i] = currVal + max;
        }
        
        return dp[n-1];
        
    }
}
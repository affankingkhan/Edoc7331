class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i<n; i++ ){
            int range = nums[i];
            for(int j = i+1; j<=i+range; j++){
                if(j > n - 1){
                    break;
                }
                dp[j] = Math.min(dp[j],dp[i] + 1);   
            }
        }
        
        return dp[n-1];
    }
}
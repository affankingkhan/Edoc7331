class Solution {
    int[][] dp;
    public int stoneGameVII(int[] stones) {

        int n = stones.length;
        dp = new int[n][n];
        
        int total = 0;
        for(int stone : stones){
            total += stone;
        }
        int i = 0;
        int j = stones.length - 1;
        return solve(stones,i,j,total);
    }
    
    
    private int solve(int[] stones, int i, int j, int total){
        // if there is only 1 element, the score becomes 0
        if(i == j) return 0;
        // if the current stone i through j have been stored in dp return them
        // no need to recompute
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        // left is the score if we take the left element
        int left = total - stones[i];
        
        // right is the score if we take the right element
        int right = total - stones[j];
        
        // we are trying to maximize the difference for the current user
        int val = Math.max(left - solve(stones,i+1, j, left), right - solve(stones,i, j-1, right));
        // cache the value for the current i, j in dp
        dp[i][j] = val;
        return val;
    }
    
    
}
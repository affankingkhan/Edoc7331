class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] ret = new int[cost.length];
        int n = cost.length;

        ret[0] = cost[0];
        ret[1] = cost[1];
        
        for(int i = 2; i< n; i++){
            ret[i] = cost[i] + Math.min(ret[i-1],ret[i-2]);
        }
        
        return Math.min(ret[n-1], ret[n-2]);
        
        
    }
}
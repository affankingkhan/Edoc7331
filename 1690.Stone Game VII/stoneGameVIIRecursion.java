class Solution {
    public int stoneGameVII(int[] stones) {
        
        int total = 0;
        for(int stone : stones){
            total += stone;
        }
        int i = 0;
        int j = stones.length - 1;
        return solve(stones,i,j,total);
    }
    
    
    private int solve(int[] stones, int i, int j, int total){
        if(i == j) return 0;
        
        int left = total - stones[i];
        
        
        int right = total - stones[j];
        
        return Math.max(left - solve(stones,i+1, j, left), right - solve(stones,i, j-1, right));
        
        
    }
    
    
}
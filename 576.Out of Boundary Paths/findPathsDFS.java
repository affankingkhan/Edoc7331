//https://leetcode.com/problems/out-of-boundary-paths/
class Solution {
    int M = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return (int) (dfs(m,n,maxMove,startRow,startColumn) % M);
    }
    
    
    private long dfs(int m, int n, int maxMove,int i, int j){
        if(i < 0 || i >= m || j<0 || j >= n) return 1L;
        if(maxMove == 0) return 0L;
        
        return (dfs(m , n, maxMove -1 , i + 1, j) + 
            dfs(m , n, maxMove -1 , i - 1, j) +
            dfs(m , n, maxMove -1 , i, j+ 1) +
            dfs(m , n, maxMove -1 , i, j - 1)) % M ;
        
        
        
    }
}
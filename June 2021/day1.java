class Solution {
    int localCount; 
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int global = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    localCount = 0;
                    dfs(grid, i, j,m,n);
                    global = Math.max(global, localCount);
                }
            }
        }
        return global;
        
    }
    
    private void dfs(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n) return;
        if(grid[i][j] == 0) return;
        
        if(grid[i][j] == 1){
            localCount++;
        }
        grid[i][j] = 0;
        if(i >0 || i < m)
        dfs(grid, i-1, j, m, n);
        dfs(grid, i+1, j, m, n);
        dfs(grid, i, j-1, m, n);
        dfs(grid, i, j+1, m, n);
        
        return;
        
    }
}
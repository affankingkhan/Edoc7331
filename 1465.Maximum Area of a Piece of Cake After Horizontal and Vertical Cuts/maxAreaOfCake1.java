// DFS solution

class Solution {
    HashSet<Integer> hSet;
    HashSet<Integer> vSet;
    int localCount = 0;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        hSet = new HashSet<>();
        vSet = new HashSet<>();
        
        for(int k : horizontalCuts){
            hSet.add(k);
        }
        
        for(int k : verticalCuts){
            vSet.add(k);
        }
        
        int[][] matrix = new int[h][w];
        
        int ret = 0;
        
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                if(matrix[i][j] == 0){
                    localCount = 0;
                    dfs(matrix,i,j,h,w);
                    ret = Math.max(ret, localCount);
                }
            }
        }
        return ret;
        
        
        
    }
    
    private void dfs(int[][] matrix, int i, int j, int h, int w){
        if(i < 0 || j <0 || i >= h || j >= w) return;
        
        if(matrix[i][j] == 1) return;
        
        matrix[i][j] = 1;
        localCount++;
        
        if(!vSet.contains(j+1)){
            dfs(matrix, i, j+1, h, w);
        }
        if(!vSet.contains(j-1)){
            dfs(matrix, i, j-1, h, w);
        }
        
        if(!hSet.contains(i+1)){
            dfs(matrix, i+1, j, h, w);
        }
        if(!hSet.contains(i-1)){
            dfs(matrix, i-1, j, h, w);
        }
        
        return;
        
    }
    
    
    
    
}
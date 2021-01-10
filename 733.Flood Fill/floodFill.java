class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor != image[sr][sc]){
            dfs(image,sr,sc,newColor,image[sr][sc]);  
        }
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int prevColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if(image[sr][sc] != prevColor) return;
        
        image[sr][sc] = newColor;
        dfs(image,sr-1,sc,newColor,prevColor);
        dfs(image,sr+1,sc,newColor,prevColor);
        dfs(image,sr,sc-1,newColor,prevColor);
        dfs(image,sr,sc+1,newColor,prevColor);
        return;
        
    }
    
    
}
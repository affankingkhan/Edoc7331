class Solution {
    public int countSquares(int[][] matrix) {
        
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Math.max(m,n);
        
        for(int i = 1; i< max; i++){
            int iCount = 0;
            for(int j= 0; j<m; j++ ){
                for(int k=0; k<n; k++){
                    if(matrix[j][k] == i){
                        iCount += isPartOfMatrixOfNDimension(matrix,j,k,m,n,i);
                    }
                    
                }
            }
            if(iCount == 0) break;
            
            count += iCount;
            
        }
        return count;
        
    }
    
    private int isPartOfMatrixOfNDimension(int[][] matrix, int i, int j, int m, int n, int dim){
        int yEnd = i+ dim; 
        int xEnd = j+dim;
        if(xEnd > n || yEnd >m) return 0;
    
        
        for(int y = i; y< yEnd; y++){
            for(int x = j; x<xEnd; x++){
                if(matrix[y][x] == 0) return 0;
            }
        }
        matrix[i][j] = dim+1;
        
        return 1;
    }0
    
}
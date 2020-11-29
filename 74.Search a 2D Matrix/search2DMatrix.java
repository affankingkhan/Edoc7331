class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        if(n == 0){
            return false;
        }
        
        int row = 0;
        for(int i = 0; i<m; i++){
            if(target >= matrix[i][0]){
                row = i;
            }else{
                break;
            }
        }
        if(target > matrix[row][n-1]){
            return false;
        }
        
        for(int j = 0; j<n;j++){
            if(matrix[row][j] == target){
                return true;
            }
        }
        return false;
    }
}
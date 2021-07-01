//https://binarysearch.com/problems/Number-of-Islands
import java.util.*;

class Solution {
    int[][] moves = {{1,0},{0,1}, {-1, 0},{0,-1}};
    
    public int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 1){
                    count++;
                    dfs(matrix, i, j, m, n);

                }
            }
        }
        return count;

        
    }

    private void dfs(int[][] matrix, int i, int j,int m , int n){
        if(i < 0 || i >= m || j < 0 || j >= n) return;

        if(matrix[i][j] == 0)return;

        matrix[i][j] = 0;

        for(int[] move : moves){
            dfs(matrix, i + move[0], j + move[1], m,n);
        }
        return;


    }


}
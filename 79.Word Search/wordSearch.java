class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    // int[][] aux = new int[m][n];
                    boolean ret = dfs(board,i,j,0,word, m, n);
                    if(ret == true){
                        return ret;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][]board, int i, int j, int wordIdx, String word, int m, int n){
        if(i<0 || j<0 || i>=m || j>= n) return false;
        if (board[i][j] != word.charAt(wordIdx)) return false;
        if(wordIdx > word.length() -1) return false;
        if(wordIdx == word.length() -1 && board[i][j] == word.charAt(wordIdx)) return true;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        
        
        if(dfs(board,i-1,j,wordIdx+1,word,m,n) ||
            dfs(board,i+1,j,wordIdx+1,word,m,n) ||
            dfs(board,i,j-1,wordIdx+1,word,m,n) ||
            dfs(board,i,j+1,wordIdx+1,word,m,n)){
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
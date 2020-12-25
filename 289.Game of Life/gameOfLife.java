class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                updateBoard(board,i,j,m,n);
            }
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j< n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }
        return;
    }
    
    private void updateBoard(int[][] board, int i, int j, int m, int n){
        int live = 0;
        int dead = 0;
        
        if(j-1 >= 0){
            dead += addDead(board, i, j-1);
            live += addLive(board, i, j-1);
            if(i-1 >= 0){
                dead += addDead(board, i-1, j-1);
                live += addLive(board, i-1, j-1);
            }
            if(i+1 < m){
                dead += addDead(board, i+1, j-1);
                live += addLive(board, i+1, j-1);
            }
        }
        if(i-1 >=0){
            dead += addDead(board, i-1, j);
            live += addLive(board, i-1, j);
        }
        if(i+1 < m){
            dead += addDead(board, i+1, j);
            live += addLive(board, i+1, j);
        }
        
        if(j+1 < n){
            dead += addDead(board, i, j+1);
            live += addLive(board, i, j+1);
            if(i-1 >= 0){
                dead += addDead(board, i-1, j+1);
                live += addLive(board, i-1, j+1);
            }
            if(i+1 < m){
                dead += addDead(board, i+1, j+1);
                live += addLive(board, i+1, j+1);
            }
        }
        
        if(board[i][j] == 1){
            if(live < 2 || live > 3){
                board[i][j] = -1;
            }
        }else{
            if(live == 3){
                board[i][j] = 2;
            }
        }
        return;
        
        
    }
    
    private int addDead(int[][] board, int i, int j){
        int ret = 0;
        if(board[i][j] == 0 || board[i][j] == 2){
            ret = 1;
        }
        return ret;
    }
    private int addLive(int[][] board, int i, int j){
        int ret = 1;
        if(board[i][j] == 0 || board[i][j] == 2){
            ret = 0;
        }
        return ret;
    }
}
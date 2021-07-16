// https://binarysearch.com/problems/Unidirectional-Word-Search
import java.util.*;

class Solution {
    public boolean solve(String[][] board, String word) {
        int m = board.length;
        if (m == 1)
            return false;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals(word.substring(0, 1))) {
                    if (dfs(true, board, i, j, word, board[i][j], 0, m, n)
                        || dfs(false, board, i, j, word, board[i][j], 0, m, n))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(boolean mode, String[][] board, int i, int j, String word, String curr,
        int k, int m, int n) {
        System.out.println(curr);
        if (word.equals(curr))
            return true;
        if (word.charAt(k) != curr.charAt(k))
            return false;

        if (mode) {
            if (j + 1 < n) {
                return dfs(mode, board, i, j + 1, word, curr + board[i][j + 1], k + 1, m, n);
            }
            return false;
        }

        return i + 1 < m ? dfs(mode, board, i + 1, j, word, curr + board[i + 1][j], k + 1, m, n)
                         : false;
    }
}
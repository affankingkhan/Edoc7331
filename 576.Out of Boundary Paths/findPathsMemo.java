//https://leetcode.com/problems/out-of-boundary-paths/submissions/
class Solution {
    int M = 1000000007;
    long[][][] memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new long[m][n][maxMove + 1];
        for (long[][] grid : memo){
            for (long[] moveArr : grid) {
                Arrays.fill(moveArr, -1L);
            }
        }
        return (int) (dfs(m, n, maxMove, startRow, startColumn) % M);
    }   

    public long dfs(int m, int n, int maxMove, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) return 1L;
        if (maxMove == 0) return 0L;
        if (memo[i][j][maxMove] >= 0L) return memo[i][j][maxMove];
        
        memo[i][j][maxMove] = (
            (dfs(m, n, maxMove - 1, i - 1, j) + dfs(m, n, maxMove - 1, i + 1, j)) +
            (dfs(m, n, maxMove - 1, i, j - 1) + dfs(m, n, maxMove - 1, i, j + 1))
        ) % M;
        return memo[i][j][maxMove];
    }
}
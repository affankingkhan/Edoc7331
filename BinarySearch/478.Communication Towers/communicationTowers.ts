//https://binarysearch.com/problems/Communication-Towers
class Solution {
    solve(matrix: Array<Array<number>>): number {

        let m = matrix.length;
        let n = matrix[0].length;
        let count = 0;

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    this.dfs(matrix, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    dfs(mat: Array<Array<number>>, i: number, j: number, m: number, n: number): void {
        if (i < 0 || j < 0 || i >= m || j >= n) return;

        mat[i][j] = -1;

        // row
        for (let k = 0; k < n; k++) {
            if (mat[i][k] == 1) {
                this.dfs(mat, i, k, m, n);
            }
        }

        // row
        for (let k = 0; k < m; k++) {
            if (mat[k][j] == 1) {
                this.dfs(mat, k, j, m, n);
            }
        }

    }
}
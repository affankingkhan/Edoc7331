//https://binarysearch.com/problems/Column-Sort
class Solution {
    solve(mat: Array<Array<number>>): Array<Array<number>> {
        let m = mat.length;
        let n = mat[0].length;
        for (let j = 0; j < n; j++) {
            let arr = [];
            for (let i = 0; i < m; i++) {
                arr.push(mat[i][j]);
            }
            arr.sort((a, b) => a - b);

            for (let i = 0; i < m; i++) {
                mat[i][j] = arr[i];
            }

        }
        return mat;

    }

}
//https://binarysearch.com/problems/Toeplitz-Matrix
class Solution {
    solve(matrix: Array<Array<number>>): boolean {

        let m = matrix.length;
        let n = matrix[0].length;

        let i = 0;
        let j = 0;

        while (i < m && j < n) {
            let k = i;
            let l = j;
            let val = matrix[i][j];
            while (k < m && l < n) {
                if (matrix[k++][l++] != val) return false;

            }
            j++;
        }
        i = 1;
        j = 0

        while (i < m && j < n) {
            let k = i;
            let l = j;
            let val = matrix[i][j];
            while (k < m && l < n) {
                if (matrix[k++][l++] != val) return false;

            }
            i++;
        }

        return true;


    }
}
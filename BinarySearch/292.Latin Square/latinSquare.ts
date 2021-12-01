//https://binarysearch.com/problems/Latin-Square
class Solution {
    solve(matrix: Array<Array<string>>): boolean {
        const n = matrix.length;
        const rowSet = new Set<string>();
        const colSet = new Set<string>();
        const letterSet = new Set<string>();

        for (let j = 0; j < n; j++) {
            const c = matrix[0][j];
            letterSet.add(c);
        }
        if (letterSet.size != n) return false;

        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                const c = matrix[i][j];
                const rowVal = `${c}${i}`;
                const colVal = `${c}${j}`;
                if (!letterSet.has(c) || rowSet.has(rowVal) || colSet.has(colVal)) return false;
                rowSet.add(rowVal);
                colSet.add(colVal);
            }
        }

        return true;
    }
}
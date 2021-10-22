// https://binarysearch.com/problems/City-Blocks
import java.util.*;

class Solution {
    public int solve(String[][] matrix, String[] blocks) {
        int m = matrix.length;
        int n = matrix[0].length;

        HashSet<String> set = new HashSet<>();

        for (String block : blocks) {
            set.add(block);
        }

        HashMap<String, int[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String curr = matrix[i][j];
                if (set.contains(curr)) {
                    map.put(curr, new int[] {i, j});
                }
            }
        }

        int distance = 0;

        int currI = 0;
        int currJ = 0;

        for (String block : blocks) {
            int[] cord = map.get(block);
            int diffI = Math.abs(cord[0] - currI);
            int diffJ = Math.abs(cord[1] - currJ);
            distance += (diffI + diffJ);
            currI = cord[0];
            currJ = cord[1];
        }
        return distance;
    }
}
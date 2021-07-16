// https://binarysearch.com/problems/Swapping-Socks
import java.util.*;

class Solution {
    public int solve(int[] row) {
        int n = row.length;
        int[] partner = new int[n];

        for (int i = 0; i < n; i += 2) {
            int a = row[i];
            int b = row[i + 1];
            partner[a] = b;
            partner[b] = a;
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            int conjugate = findOtherPair(i);

            int p = partner[i];
            if (p != conjugate) {
                int actual = partner[conjugate];
                partner[i] = conjugate;
                partner[conjugate] = i;
                partner[p] = actual;
                partner[actual] = p;
                count++;
            }
        }
        return count;
    }

    private int findOtherPair(int n) {
        if (n % 2 == 0)
            return n + 1;
        return n - 1;
    }
}
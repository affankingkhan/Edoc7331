// https://binarysearch.com/problems/Lexicographically-Smallest-Non-Palindromic-String
import java.util.*;

class Solution {
    public String solve(String s) {
        char[] sCh = s.toCharArray();
        int m = s.length();

        int n = m / 2;
        boolean isBroken = false;

        for (int i = 0; i < n; i++) {
            if (sCh[i] - 'a' > 0) {
                sCh[i] = 'a';
                isBroken = true;
                break;
            }
        }

        if (!isBroken) {
            sCh[m - 1] = 'b';
        }

        return String.valueOf(sCh);
    }
}
// https://binarysearch.com/problems/Pair-and-Triples
import java.util.*;

class Solution {
    public boolean solve(String s) {
        // use an array instead of a hash map
        int[] freq = new int[10];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - '0']++;
        }

        int two = 0;
        for (int i = 0; i < 10; i++) {
            // freq[i] divide 3 has a remainder of 2
            // that means it must be a multiple of 2
            if (freq[i] % 3 == 2) {
                two++;
                if (two > 1) {
                    return false;
                }
            } else if (freq[i] % 3 != 0) {
                return false;
            }
        }

        return two == 1;
    }
}
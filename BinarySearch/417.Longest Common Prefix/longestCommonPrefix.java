// https://binarysearch.com/problems/Longest-Common-Prefix
import java.util.*;

class Solution {
    public String solve(String[] words) {
        int n = words.length;
        if (n == 1)
            return words[0];
        StringBuilder ret = new StringBuilder();
        String base = words[0];
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            boolean isBroken = false;
            for (int j = 1; j < n; j++) {
                String word = words[j];
                if (word.length() <= i || word.charAt(i) != c) {
                    isBroken = true;
                    break;
                }
            }
            if (isBroken)
                break;
            else {
                ret.append(c);
            }
        }

        return ret.toString();
    }
}
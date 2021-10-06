// https://binarysearch.com/problems/Remove-One-Letter
import java.util.*;

class Solution {
    public boolean solve(String s0, String s1) {
        if (s0.length() != s1.length() + 1)
            return false;

        int i = 0;
        int j = 0;

        char[] s0Ch = s0.toCharArray();
        char[] s1Ch = s1.toCharArray();

        boolean found = false;

        while (i < s0Ch.length && j < s1Ch.length) {
            if (s0Ch[i] != s1Ch[j]) {
                if (found)
                    return false;
                else {
                    found = true;
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }

        return true;
    }
}
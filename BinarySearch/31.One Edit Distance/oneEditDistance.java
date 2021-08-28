// https://binarysearch.com/problems/One-Edit-Distance
import java.util.*;

class Solution {
    public boolean solve(String s0, String s1) {
        if (s0.equals(s1))
            return true;

        char[] s0Char = s0.toCharArray();
        char[] s1Char = s1.toCharArray();

        int l0 = s0Char.length;
        int l1 = s1Char.length;
        if (Math.abs(l0 - l1) > 1)
            return false;

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < l0 && j < l1) {
            if (s0Char[i] != s1Char[j]) {
                count++;
                if (count >= 2)
                    break;
                if (l0 > l1) {
                    i++;
                } else if (l0 < l1) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return count < 2;
    }
}
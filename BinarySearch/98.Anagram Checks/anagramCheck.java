// https://binarysearch.com/problems/Anagram-Checks
import java.util.*;

class Solution {
    public boolean solve(String s0, String s1) {
        int[] map = new int[26];

        for (char c : s0.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : s1.toCharArray()) {
            map[c - 'a']--;
        }

        for (int i : map) {
            if (i != 0)
                return false;
        }

        return true;
    }
}
// https://binarysearch.com/problems/ASCII-String-to-Integer
import java.util.*;

class Solution {
    public int solve(String s) {
        String curr = "";
        int sum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (curr.length() > 0) {
                    sum += Integer.valueOf(curr);
                    curr = "";
                }
            } else {
                curr += c;
            }
        }

        if (curr.length() > 0) {
            sum += Integer.valueOf(curr);
            curr = "";
        }
        return sum;
    }
}
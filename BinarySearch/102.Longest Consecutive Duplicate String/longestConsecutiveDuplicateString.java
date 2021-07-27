// https://binarysearch.com/problems/Longest-Consecutive-Duplicate-String
import java.util.*;

class Solution {
    public int solve(String s) {
        char curr = '\0';
        int currCount = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c != curr) {
                curr = c;
                currCount = 1;

            } else {
                currCount++;
            }
            ans = Math.max(ans, currCount);
        }

        return ans;
    }
}
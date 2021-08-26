// https://binarysearch.com/problems/Removing-Parentheses
import java.util.*;

class Solution {
    public int solve(String s) {
        int count = 0;

        int openCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                if (openCount == 0)
                    count++;
                else {
                    openCount--;
                }
            }
        }

        count += openCount;
        return count;
    }
}
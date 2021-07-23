// https://binarysearch.com/problems/Minimum-Bracket-Addition
import java.util.*;

class Solution {
    public int solve(String s) {
        int count = 0;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    count++;
                else {
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }
}
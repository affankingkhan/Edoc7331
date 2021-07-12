// https://binarysearch.com/problems/Balanced-Brackets-Sequel
import java.util.*;

class Solution {
    public boolean solve(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('[');
        open.add('{');

        for (char c : s.toCharArray()) {
            if (open.contains(c))
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char o = stack.pop();
                if (getConjugate(c) != o)
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private char getConjugate(char c) {
        if (c == ']') {
            return '[';
        }

        if (c == ')') {
            return '(';
        }

        return '{';
    }
}
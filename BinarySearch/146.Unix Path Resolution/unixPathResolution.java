// https://binarysearch.com/problems/Unix-Path-Resolution
import java.util.*;

class Solution {
    public String[] solve(String[] path) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String folder : path) {
            if (folder.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!folder.equals(".")) {
                stack.push(folder);
            }
        }

        int n = stack.size();

        String[] ret = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
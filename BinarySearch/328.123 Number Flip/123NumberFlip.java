//https://binarysearch.com/problems/123-Number-Flip
import java.util.*;

class Solution {
    public int solve(int n) {
        char[] num = String.valueOf(n).toCharArray();

        boolean found = false;
        int len = num.length;

        for (int i = 0; i < len; i++) {
            if (num[i] != '3') {
                found = true;
                num[i] = '3';
                break;
            }
        }

        if (!found)
            return n;

        return Integer.parseInt(String.valueOf(num));
    }
}
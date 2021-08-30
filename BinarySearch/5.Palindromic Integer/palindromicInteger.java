//https://binarysearch.com/problems/Palindromic-Integer
import java.util.*;

class Solution {
    public boolean solve(int num) {
        char[] str = String.valueOf(num).toCharArray();

        int n = str.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (str[i++] != str[j--])
                return false;
        }
        return true;
    }
}
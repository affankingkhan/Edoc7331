// https://binarysearch.com/problems/Noisy-Palindrome
import java.util.*;

class Solution {
    public boolean solve(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        char[] ch = s.toCharArray();

        while (i < j) {
            while (!Character.isLowerCase(ch[i])) {
                i++;
                if (i == n)
                    return true;
            }

            while (!Character.isLowerCase(ch[j])) {
                j--;
            }
            if (i > j)
                break;

            if (ch[i++] != ch[j--])
                return false;
        }

        return true;
    }
}
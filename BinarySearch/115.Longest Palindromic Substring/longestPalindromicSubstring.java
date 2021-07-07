// https://binarysearch.com/problems/Longest-Palindromic-Substring
import java.util.*;

class Solution {
    public int solve(String s) {
        char[] sCh = s.toCharArray();

        int n = sCh.length;

        int longest = 0;

        for (int i = 0; i < n; i++) {
            // not possible to find a larger palindrome, we exit
            if ((n - i) * 2 <= longest) {
                break;
            }
            longest = Math.max(longest, findPalindrome(sCh, i, n));
        }
        return longest;
    }

    private int findPalindrome(char[] str, int i, int n) {
        int countEven = 0;

        int j = i;
        int k = i - 1;

        while (k >= 0 && j < n) {
            if (str[k--] == str[j++]) {
                countEven += 2;
            } else {
                break;
            }
        }

        int countOdd = 1;

        j = i + 1;
        k = i - 1;

        while (k >= 0 && j < n) {
            if (str[k--] == str[j++]) {
                countOdd += 2;
            } else {
                break;
            }
        }

        return Math.max(countEven, countOdd);
    }
}
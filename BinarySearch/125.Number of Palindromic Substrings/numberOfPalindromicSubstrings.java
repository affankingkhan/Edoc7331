// https://binarysearch.com/problems/Number-of-Palindromic-Substrings
import java.util.*;

class Solution {
    public int solve(String s) {
        int count = 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count += countNumPalindromes(arr, i);
        }
        return count;
    }

    private int countNumPalindromes(char[] arr, int i) {
        int n = arr.length;
        int count = 0;

        int j = i;
        int k = i;

        while (j >= 0 && k < n) {
            if (arr[j--] == arr[k++])
                count++;
            else {
                break;
            }
        }

        j = i;
        k = i + 1;

        while (j >= 0 && k < n) {
            if (arr[j--] == arr[k++])
                count++;
            else {
                break;
            }
        }

        return count;
    }
}
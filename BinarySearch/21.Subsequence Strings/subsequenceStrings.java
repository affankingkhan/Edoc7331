// https://binarysearch.com/problems/Subsequence-Strings
import java.util.*;

class Solution {
    public boolean solve(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (j >= arr1.length)
                break;
            if (arr1[j] == arr2[i])
                j++;
        }
        return j == arr1.length;
    }
}
// https://binarysearch.com/problems/Next-Integer-Permutation
import java.util.*;

class Solution {
    public int solve(int n) {
        String str = Integer.toString(n);
        char[] strCh = str.toCharArray();

        int l = strCh.length;

        int j = l - 2;

        while (j >= 0) {
            if (strCh[j] - '0' < strCh[j + 1] - '0')
                break;
            j--;
        }

        if (j >= 0) {
            // reverse the string
            int numLeft = strCh[j] - '0';
            int k = l - 1;
            while (k >= 0) {
                if (strCh[k] - '0' > numLeft)
                    break;
                k--;
            }

            swap(strCh, j, k);
        }

        int i = j + 1;
        int m = l - 1;

        while (i < m) {
            swap(strCh, i, m);
            i++;
            m--;
        }
        String ret = String.valueOf(strCh);
        return Integer.parseInt(ret);
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
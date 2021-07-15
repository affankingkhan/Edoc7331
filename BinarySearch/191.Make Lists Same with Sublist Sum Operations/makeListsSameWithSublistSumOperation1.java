// https://binarysearch.com/problems/Make-Lists-Same-with-Sublist-Sum-Operations
import java.util.*;

class Solution {
    public int solve(int[] l0, int[] l1) {
        int m = l0.length;
        int n = l1.length;

        if (m == 0 && n == 0)
            return 0;
        if (m == 0 || n == 0)
            return -1;

        ArrayList<Integer> ret = new ArrayList<>();

        int i = 0, j = 0, sum0 = l0[0], sum1 = l1[0];

        while (i < m && j < n) {
            if (sum0 == sum1) {
                ret.add(sum0);
                i++;
                j++;
                sum0 = i < m ? l0[i] : 0;
                sum1 = j < n ? l1[j] : 0;

            } else {
                if (sum0 < sum1) {
                    i++;
                    sum0 += i < m ? l0[i] : 0;
                } else {
                    j++;
                    sum1 += j < n ? l1[j] : 0;
                }
            }
        }

        while (i < m) {
            i++;
            sum0 += i < m ? l0[i] : 0;
        }

        while (j < n) {
            j++;
            sum1 += j < n ? l1[j] : 0;
        }

        if (sum0 == sum1 && sum0 != 0) {
            ret.add(sum0);
        }
        if (sum0 != sum1) {
            return -1;
        }

        return ret.size();
    }
}
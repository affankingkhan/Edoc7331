// https://binarysearch.com/problems/Look-and-Say
import java.util.*;

class Solution {
    public String solve(int n) {
        String curr = "1";

        while (n > 1) {
            StringBuilder next = new StringBuilder();
            char[] currCh = curr.toCharArray();
            char dig = currCh[0];
            int count = 1;
            for (int i = 1; i < currCh.length; i++) {
                if (currCh[i] == dig) {
                    count++;
                } else {
                    next.append(count);
                    next.append(dig);
                    dig = currCh[i];
                    count = 1;
                }
            }

            next.append(count);
            next.append(dig);
            curr = next.toString();

            n--;
        }

        return curr;
    }
}
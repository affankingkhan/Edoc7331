// https://binarysearch.com/problems/Happy-Numbers
import java.util.*;

class Solution {
    public boolean solve(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            int k = n;
            int sum = 0;
            while (k > 0) {
                int dig = k % 10;
                sum += (int) Math.pow(dig, 2);
                k /= 10;
            }
            if (set.contains(sum))
                return false;
            set.add(sum);
            n = sum;
        }

        return n == 1;
    }
}
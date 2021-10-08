// https://binarysearch.com/problems/Number-of-Bits
import java.util.*;

class Solution {
    public int solve(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int val = n & bit;
            if (val != 0)
                count++;
        }
        return count;
    }
}
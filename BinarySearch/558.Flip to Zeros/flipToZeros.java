// https://binarysearch.com/problems/Flip-to-Zeros
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if ((count % 2 == 0 && n == 1) || (count % 2 == 1 && n == 0)) {
                count++;
            }
        }

        return count;
    }
}
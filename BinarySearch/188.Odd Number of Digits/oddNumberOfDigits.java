// https://binarysearch.com/problems/Odd-Number-of-Digits
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int ret = 0;
        int[] map = {
            0, 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000};
        for (int num : nums) {
            int i = 9;
            while (num < map[i]) {
                i--;
            }
            if ((i + 1) % 2 == 1)
                ret++;
        }
        return ret;
    }
}
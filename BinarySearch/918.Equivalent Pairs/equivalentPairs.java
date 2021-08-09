// https://binarysearch.com/problems/Equivalent-Pairs
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int n : nums) {
            if (map.containsKey(n)) {
                count += map.get(n);
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;
    }
}
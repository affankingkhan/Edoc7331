// https://binarysearch.com/problems/Number-of-Quadruplets-That-Sum-Target
import java.util.*;

class Solution {
    public int solve(int[] a, int[] b, int[] c, int[] d, int target) {
        HashMap<Integer, Integer> mapAB = new HashMap<>();

        for (int i : a) {
            for (int j : b) {
                int curr = i + j;
                mapAB.put(curr, mapAB.getOrDefault(curr, 0) + 1);
            }
        }

        int count = 0;

        for (int i : c) {
            for (int j : d) {
                int curr = i + j;
                int conjugate = target - curr;
                count += mapAB.getOrDefault(conjugate, 0);
            }
        }
        return count;
    }
}
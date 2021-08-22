// https://binarysearch.com/problems/Sum-of-Four-Numbers-Less-Than-Target
import java.util.*;

class Solution {
    public int solve(int[] A, int[] B, int[] C, int[] D, int target) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                map2.put(sum, map2.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int sum1 : map1.keySet()) {
            for (int sum2 : map2.keySet()) {
                int sum = sum1 + sum2;
                if (sum <= target) {
                    count += (map1.get(sum1) * map2.get(sum2));
                }
            }
        }

        return count;
    }
} 
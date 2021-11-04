// https://binarysearch.com/problems/Remove-Last-Duplicate-Entries
import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> lastIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            lastIdx.put(num, i);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int count = countMap.get(num);
            int idx = lastIdx.get(num);
            if (count > 1 && idx == i)
                continue;

            list.add(num);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
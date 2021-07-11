// https://binarysearch.com/problems/Largest-Anagram-Group
import java.util.*;

class Solution {
    public int solve(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            char[] chArr = word.toCharArray();

            Arrays.sort(chArr);

            String str = new String(chArr);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int max = 0;

        for (String s : map.keySet()) {
            System.out.println(s);
            int l = map.get(s);
            max = Math.max(max, l);
        }

        return max;
    }
}
// https://binarysearch.com/problems/Common-Words
import java.util.*;

class Solution {
    public int solve(String s0, String s1) {
        if (s1.length() == 0 || s0.length() == 0)
            return 0;
        int count = 0;
        s0 = s0.toLowerCase();
        s1 = s1.toLowerCase();

        String[] words0 = s0.split(" ");

        Set<String> dic = new HashSet<>();
        for (String word : words0) {
            dic.add(word);
        }

        String[] words1 = s1.split(" ");
        Set<String> vis = new HashSet<>();

        for (String word : words1) {
            if (!vis.contains(word)) {
                if (dic.contains(word))
                    count++;
                vis.add(word);
            }
        }

        return count;
    }
}
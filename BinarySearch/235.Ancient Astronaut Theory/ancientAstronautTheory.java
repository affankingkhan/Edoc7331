// https://binarysearch.com/problems/Ancient-Astronaut-Theory
import java.util.*;

class Solution {
    public boolean solve(String dictionary, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] dict = dictionary.toCharArray();

        for (int i = 0; i < dict.length; i++) {
            map.put(dict[i], i);
        }

        char[] sCh = s.toCharArray();

        int largest = -1;

        for (int i = 0; i < sCh.length; i++) {
            char c = sCh[i];
            if (map.containsKey(c)) {
                int val = map.get(c);
                if (val < largest)
                    return false;
                largest = val;
            }
        }

        return true;
    }
}
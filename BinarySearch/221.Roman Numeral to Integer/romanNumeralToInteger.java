// https://binarysearch.com/problems/Roman-Numeral-to-Integer
import java.util.*;

class Solution {
    public int solve(String numeral) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i = 0;
        char[] sCh = numeral.toCharArray();
        int n = sCh.length;
        int ans = 0;

        while (i < n) {
            char curr = sCh[i];
            int one = map.get(curr);
            char next = i + 1 < n ? sCh[i + 1] : '\0';
            if (next != '\0') {
                int two = map.get(next);
                if (two > one) {
                    ans += (two - one);
                    i += 2;
                } else {
                    ans += one;
                    i++;
                }

            } else {
                ans += one;
                i++;
            }
        }
        return ans;
    }
}
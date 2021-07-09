// https://binarysearch.com/problems/Word-Formation-Sequel
import java.util.*;

class Solution {
    public int solve(String[] words, String letters) {
        int curr = 0;
        for (String word : words) {
            if (word.length() <= curr)
                continue;

            if (validateWord(word, letters)) {
                curr = word.length();
            }
        }

        return curr;
    }

    private boolean validateWord(String word, String letters) {
        int[] map = new int[27];

        for (char c : letters.toCharArray()) {
            if (c == '*') {
                map[26]++;
            } else {
                map[c - 'a']++;
            }
        }

        for (char c : word.toCharArray()) {
            int charCount = map[c - 'a'];
            if (charCount > 0) {
                map[c - 'a']--;
            } else {
                if (map[26] <= 0) {
                    return false;
                }
                map[26]--;
            }
        }

        return true;
    }
}
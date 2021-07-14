// https://binarysearch.com/problems/Minimum-Distance-of-Two-Words-in-a-Sentence
import java.util.*;

class Solution {
    public int solve(String text, String word0, String word1) {
        String[] words = text.split(" ");

        int n = words.length;

        int word0Idx = -1;
        int word1Idx = -1;

        boolean foundWord0 = false;
        boolean foundWord1 = false;

        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (word.equals(word0)) {
                foundWord0 = true;
                word0Idx = i;
                if (word1Idx != -1) {
                    distance = Math.min(distance, i - word1Idx - 1);
                }
            }
            if (word.equals(word1)) {
                foundWord1 = true;
                word1Idx = i;
                if (word0Idx != -1) {
                    distance = Math.min(distance, i - word0Idx - 1);
                }
            }
        }

        return foundWord0 && foundWord1 ? distance : -1;
    }
}
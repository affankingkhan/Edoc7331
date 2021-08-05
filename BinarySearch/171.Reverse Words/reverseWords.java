// https://binarysearch.com/problems/Reverse-Words
import java.util.*;

class Solution {
    public String solve(String sentence) {
        String[] words = sentence.split(" ");

        int n = words.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (sb.length() != 0) {
                sb.append(" ");
            }

            sb.append(word);
        }
        return sb.toString();
    }
}
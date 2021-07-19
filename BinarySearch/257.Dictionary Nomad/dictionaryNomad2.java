// https://binarysearch.com/problems/Dictionary-Nomad
import java.util.*;

class Solution {
    public int solve(String[] dictionary, String start, String end) {
        Map<String, Boolean> vWords = new HashMap<>();
        for (String s : dictionary) {
            vWords.put(s, false);
        }
        if (!vWords.containsKey(end))
            return -1;

        ArrayDeque<String> states = new ArrayDeque<>();
        int level = 1;
        states.offer(start);
        while (!states.isEmpty()) {
            int size = states.size();
            while (size-- > 0) {
                String node = states.poll();
                vWords.put(node, true);
                if (end.equals(node))
                    return level;
                generateNextStates(states, node, vWords);
            }
            level++;
        }
        return -1;
    }
    private void generateNextStates(
        ArrayDeque<String> states, String word, Map<String, Boolean> vWords) {
        for (int i = 0; i < word.length(); i++) {
            char[] ch = word.toCharArray();
            for (int j = 0; j < 26; j++) {
                ch[i] = (char) (j + 97);
                String str = String.valueOf(ch);
                if (vWords.containsKey(str) && !vWords.get(str))
                    states.offer(str);
            }
        }
    }
}
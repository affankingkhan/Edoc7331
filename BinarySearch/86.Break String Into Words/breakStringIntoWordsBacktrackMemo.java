// https://binarysearch.com/problems/Break-String-Into-Words
import java.util.*;

class Solution {
    Set<String> dict;
    Map<String, Boolean> memo;
    public boolean solve(String[] words, String s) {
        if (s == null || s.isEmpty() || words.length == 0) return false;
        memo = new HashMap<>();
        dict = new HashSet<>();
        for(String word : words){
            dict.add(word);
        }
        return explore(s);
    }
    
    private boolean explore(String s) {
        if (s.isEmpty() || dict.contains(s)) return true;
        Boolean res = memo.get(s);
        if (res != null) return res;
        res = false;
        int L = s.length();
        for (int i = 1; i < L; i++) {
            String substr1 = s.substring(0, i);
            if (dict.contains(substr1)) {
                String substr2 = s.substring(i, L);
                res = explore(substr2);
                if (res == true) {
                    break;
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
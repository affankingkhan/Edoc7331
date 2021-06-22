https://leetcode.com/problems/number-of-matching-subsequences/
class Solution {
    
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        for(String word: list){
            if(isSubsequence(s, word)){
                count = count + map.get(word);
            }
        }
        return count;
    }
    
    public boolean isSubsequence(String s, String word){
        // if the String s is smaller than the word, word cannot be a subsequence of s
        if(s.length() < word.length()) return false;
        
        int prevIdx = 0;
        for(char ch : word.toCharArray()){
            int idx = s.indexOf(ch, prevIdx);
            if(idx == -1) return false;
            prevIdx = idx + 1;
        }
        return true;
    }
    
}
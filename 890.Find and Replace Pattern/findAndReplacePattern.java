class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        
        for(String word: words){
            if(this.isValidPattern(word,pattern)) ret.add(word);
        }
        
        return ret;
        
    }
    
    private boolean isValidPattern(String word, String pattern){
        
        // pattern letter -> word letter
        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i< word.length(); i++){
            char wLetter = word.charAt(i);
            char pLetter = pattern.charAt(i);
            
            //if new letter
            if(map.get(pLetter) == null){
                if(set.contains(wLetter)){
                    return false;
                }
                map.put(pLetter,wLetter);
            }
            else{
                if(map.get(pLetter) != wLetter){
                    return false;
                }
            }
            set.add(wLetter);
            
        }
        return true;
            
    
        
        
    }
}
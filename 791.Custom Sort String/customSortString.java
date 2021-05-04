class Solution {
    public String customSortString(String S, String T) {
        
        int[] map = new int[26];
        
        for(char c : T.toCharArray()) map[c - 'a']++;
        
    
        
        StringBuilder ret = new StringBuilder();
        
        for(char s : S.toCharArray()){
            if(map[s - 'a'] > 0){
                while(map[s - 'a']-- > 0){
                    ret.append(s);
                }
            }
        }
        
        for(int i = 0; i< map.length; i++){
            if(map[i] > 0){
                while(map[i]-- > 0){
                    ret.append((char) ('a' + i));
                }
            }
        }
        
        return ret.toString();
        
    }
}
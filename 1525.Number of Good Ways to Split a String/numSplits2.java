class Solution {
    public int numSplits(String s) {
        Map<Character,Integer> mapLeft = new HashMap<>();
        Map<Character,Integer> mapRight = new HashMap<>();
        
        int count = 0;
        
        for(int i = 0; i< s.length(); i++){
            mapRight.put(s.charAt(i), mapRight.getOrDefault(s.charAt(i), 0) + 1 );
        }
    
        
        for(int i = 1; i< s.length(); i++){
            mapLeft.put(s.charAt(i-1),mapLeft.getOrDefault(s.charAt(i-1),0) + 1);
            mapRight.put(s.charAt(i-1),mapRight.get(s.charAt(i-1)) - 1);
            if(mapRight.get(s.charAt(i-1)) == 0){
                mapRight.remove(s.charAt(i-1));
            }

            
            if(this.checkIsEqual(mapLeft.keySet(), mapRight.keySet())) count++;
        }
        return count;
    }
    
    private boolean checkIsEqual(Set<Character>set1, Set<Character>set2 ){
        
        return set1.size() == set2.size();
    }
}
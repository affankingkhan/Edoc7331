class Solution {
    public int numSplits(String s) {
        int[] mapLeft = new int[26];
        int[] mapRight = new int[26];
        
        int count = 0;
        
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            mapRight[c - 'a']++;
        }
    
        
        for(int i = 1; i< s.length(); i++){
            char prev = s.charAt(i-1);
            mapLeft[prev - 'a']++;
            mapRight[prev - 'a']--;
            if(this.checkIsEqual(mapLeft,mapRight))count++;

        }
        return count;
    }
    
    private boolean checkIsEqual(int[] a1, int[] a2 ){
        
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < a2.length; i++){
            if(a1[i] > 0) count1++;
            if(a2[i] > 0) count2++;
            
        }
        return count1 == count2;
        
        
    }
}
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] left = new int[26];
        int[] right = new int[26];
        
        // populate map
        for(int i = 0; i< s1.length(); i++){
            char c = s1.charAt(i);
            char d = s2.charAt(i);
            
            left[c - 'a']++;
            right[d - 'a']++;
        }
        
        // this determines which side is breaking the other
        String side = null;
        
        
        int x = 25;
        int y = 25;
        
        int carry = 0;
        
        while(x >= 0 && y >= 0){
            // if we haven't determined which side breaks the other
            if(side == null){
               if(left[x] > right[y]){
                   side = "l";
                   carry = left[x] - right[y]; 
               }
                else if(left[x] < right[y]){
                    side = "r";
                    carry = right[y] - left[x];
                }
            }
            // if we have potentially found which side can break the other
            else{
                if(side == "l"){
                    if(carry + left[x] < right[y]){
                        return false;
                    }
                    carry = carry + left[x] - right[y];
                    
                }else{
                    if(carry + right[y] < left[x]){
                        return false;
                    }
                    carry = carry + right[y] - left[x];
                }
                
            }
            x--;
            y--;
        }
        
        return true;
        
    }
}
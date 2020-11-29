class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() < 1){
            return 0;
        }
        char[] cHaystack = haystack.toCharArray();
        char[] cNeedle = needle.toCharArray();
        
        int i = 0;
        while(i<cHaystack.length - cNeedle.length + 1){
            if(cHaystack[i] == cNeedle[0]){
                int c = i+1;
                int j = 1;
                boolean early = false;
                while(c < cHaystack.length && j<cNeedle.length){
                    if(cHaystack[c] != cNeedle[j]){
                        early = true;
                        break;
                    }else{
                        c++;
                        j++;
                    }
                }
                if(!early && j == cNeedle.length){
                    return i;
                }
                
            }
            i++;
        }
        return -1;
        
    }
}s
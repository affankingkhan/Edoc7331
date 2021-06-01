class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int countXY = 0;
        int countYX = 0;
        
        for(int i = 0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2){
                if(c1 == 'x') countXY++;
                else{
                    countYX++;
                }
            }
        }
        
        // number of simple swaps
        int simpleSwap = (countXY / 2) + (countYX / 2);
        
        // number of complex swaps
        int complexSwaps1 = (countXY % 2);
        int complexSwaps2 = (countYX % 2);
        
        if(complexSwaps1 != complexSwaps2){
            return -1;
        }
        
        return simpleSwap + complexSwaps1 + complexSwaps2;
        
    }
}
// DP solution

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        // if the lengths don't add up, return false
        if((s1.length() + s2.length()) != s3.length()) return false;
        
        // create the boolean matrix with an additional column and row
        boolean[][] M = new boolean[s1.length() + 1][s2.length() + 1];
        
        // empty string with empty string is interleving so its true
        M[0][0] = true;
        
        // populate first row, basically determining if s1= "" and s2 are interleving to create s3 ie. s2== s3
        for(int i = 1; i <= s2.length(); i++){
            if(s2.charAt(i-1) != s3.charAt(i-1)){
                M[0][i] = false;
            }
            else{
                M[0][i] = M[0][i-1];
            }
            
        }
        
        // populate first column, basically determining if s2="" and s1 are interleving to create s3 ie. s1== s3
        for(int i = 1; i <= s1.length(); i++){
            if(s1.charAt(i-1) != s3.charAt(i-1)){
                M[i][0] = false;
            }
            else{
                M[i][0] = M[i-1][0];
            }
            
        }
        
        // fill in rest of matrix
        // at each step we check if the new letter from s3 is coming from s1 or s2
        // if char is coming from s1 then we return the previous matrix value without 1 index less for s1 ie above
        // if char is coming from s2 then we return the previous matrix value without 1 index less for s2 ie left
        // if it is coming from neither we leave it false which is the default
        for(int i = 1; i<= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                char c = s3.charAt(i+j-1);
                if(s1.charAt(i-1) == c){
                    M[i][j] = M[i-1][j];
                }
                if(s2.charAt(j-1) == c){
                    M[i][j] |= M[i][j-1];
                }
            }
        }
        
        // return the last entry in the matrix
        return M[s1.length()][s2.length()];
        
    }
    
    
    
    
}
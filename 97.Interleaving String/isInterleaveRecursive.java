/// Recursive Solution (NOT OPTIMAL)

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length() + s2.length()) != s3.length()){
            return false;
        }
        return recurse(s1,s2,s3,0,0,0,"");
    }
    
    private boolean recurse(String s1, String s2, String s3, int i, int j, int k, String curr){
        
        if(s3.equals(curr) && i == s1.length() && j == s2.length()) return true;
        
        boolean ret = false;
        if(k < s3.length()){
            if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
                ret = ret || recurse(s1,s2,s3,i+1,j,k+1,curr+s1.charAt(i));
            }
            
            if(j < s2.length() && s3.charAt(k) == s2.charAt(j)){
                ret = ret || recurse(s1,s2,s3,i,j+1,k+1,curr+s2.charAt(j));
            }
            
            
        }
        
        return ret;
        
    }
}
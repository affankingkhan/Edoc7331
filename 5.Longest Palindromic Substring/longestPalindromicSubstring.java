class Solution {
    public String longestPalindrome(String s) {
        
        String palindrome = "";
        
        for(int i = 0 ; i<s.length(); i++){
            // 1 middle
            int j = i;
            int k = i;
            String currStr = "";
            while(j >= 0 && k <s.length()){
                currStr = s.substring(j, k + 1);
                if(j == k){
                    if(palindrome.length() < 1){
                        palindrome = currStr;
                    }
                    j--;
                    k++;
                    
                }
                else if(s.charAt(j) == s.charAt(k)){
                    if(currStr.length() > palindrome.length()){
                        palindrome = currStr;
                    }
                    j--;
                    k++;
                }
                else{
                    break;
                }
            }
            
            // 2 middle  
            k = i;
            j = i - 1;
            currStr = "";
            
            while(j >= 0  && k < s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    currStr = s.substring(j, k + 1);
                    j--;
                    k++;
                    if(currStr.length() > palindrome.length()){
                        palindrome = currStr;
                    }
                }
                else{
                    break;
                }
            }
            
        }
        return palindrome;
        
    }
}
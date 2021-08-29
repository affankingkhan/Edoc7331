//https://leetcode.com/problems/break-a-palindrome/
class Solution {
    public String breakPalindrome(String palindrome) {
        
        if(palindrome.length() <= 1) return "";
        
        char[] arrCh = palindrome.toCharArray();
        int n = arrCh.length;
        
        
        boolean found = false;
        for(int i = 0; i< n/2; i++){
            if(arrCh[i] != 'a'){
                arrCh[i] = 'a';
                found = true;
                break;
            }
        }
        
        if(!found){
            arrCh[arrCh.length -1] ='b';
        }
        return String.valueOf(arrCh);
        
    }
}
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class Solution {
    public String removeDuplicates(String s) {
        if(s.length() == 1) return s;
        
        
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] sCh = s.toCharArray();
        
        for(char c : sCh ){
            if(stack.peek() == null || c != stack.peek()){
                stack.push(c);
            }else{
                stack.pop();
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
        
    }
}
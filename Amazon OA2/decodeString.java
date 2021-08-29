//https://leetcode.com/problems/decode-string/
class Solution {
    public String decodeString(String s) {
        
        // stack
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            // if closing bracket
            if(c == ']'){
                StringBuilder curr = new StringBuilder();
                // keep popping off the stack until we come across opening [,
                // this will signify that curr is completely filled with letters
                while(!stack.isEmpty()){
                    String popped = stack.pop();
                    if(popped.equals("[")) break;
                    // make sure to prepend the popped character
                    curr.insert(0,popped);
                }
                
                StringBuilder num = new StringBuilder();
                // keep popping until we see a non digit character
                while(!stack.isEmpty()){
                    if(Character.isDigit(stack.peek().charAt(0))){
                        String popped = stack.pop();
                        num.insert(0,popped);
                    }
                    else{
                        break;
                    }
                }
                // now we should have the num and the string we want to repeat num times
                // push the new string onto the stack 
                stack.push(this.buildNewString(num.toString(), curr.toString()));
                
            }else{
                // if any other character, add to stack
                stack.push(String.valueOf(c));
            }
            
        }
        // just empty all the element off the stack and prepend to return string
        StringBuilder ret = new StringBuilder();
        while(!stack.isEmpty()){
            ret.insert(0, stack.pop());
        }
        return ret.toString();
        
    }
    
    // This helper method return a new string that represents str repeated num times
    private String buildNewString(String num, String str){
        StringBuilder s = new StringBuilder();
        
        int n = Integer.parseInt(num);
        
        for(int i = 0; i<n; i++){
            s.append(str);
        }
        return s.toString();
    }
}
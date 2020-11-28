class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
                else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
                else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
            
        }
        
        return stack.isEmpty();    
    }
}
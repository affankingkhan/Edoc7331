//https://leetcode.com/problems/evaluate-reverse-polish-notation/
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        for(String token : tokens){
            if(isSymbol(token)){
                int denom = Integer.valueOf(stack.pop());
                int num = Integer.valueOf(stack.pop());
                int val = 0;
                if(token.equals("+")){
                    val = denom + num;
                }
                else if(token.equals("-")){
                    val = num - denom;
                    
                }
                else if(token.equals("*")){
                    val = denom * num;
                    
                }else{
                    val = num / denom;
                    
                }
                
                stack.push(String.valueOf(val));
                
            }else{
                stack.push(token);
            }
        }
        
        return Integer.valueOf(stack.pop());
        
    }
    
    private boolean isSymbol(String str){
        return str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*");
    }
}